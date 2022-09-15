package com.chan.seller.chanseller.service;

import com.chan.seller.chanseller.client.CustomerClient;
import com.chan.seller.chanseller.common.Message;
import com.chan.seller.chanseller.common.StatusEnum;
import com.chan.seller.chanseller.domain.Address;
import com.chan.seller.chanseller.domain.Menu;
import com.chan.seller.chanseller.domain.Order;
import com.chan.seller.chanseller.domain.OrderStatus;
import com.chan.seller.chanseller.dto.CustomerOrderRequestDto;
import com.chan.seller.chanseller.dto.SellerOrderRequestDto;
import com.chan.seller.chanseller.exception.OrderRequestFailedException;
import com.chan.seller.chanseller.exception.OrderUpdateRequestFailedException;
import com.chan.seller.chanseller.repository.MenuRepository;
import com.chan.seller.chanseller.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final CustomerClient customerClient;

    private final OrderRepository orderRepository;

    private final MenuRepository menuRepository;

    @Transactional
    public Order requestOrder(SellerOrderRequestDto dto) {

        Menu menu = this.menuRepository.findById(dto.getMenuId()).orElseThrow(()->
            new OrderRequestFailedException("일치하는 메뉴 번호가 없습니다.")
        );

        //주문 생성
        Order orderRequest = Order.request(dto, menu);

        //주문 저장
        Order order = this.orderRepository.save(orderRequest);

        return order;
    }

    @Transactional
    public void ProcessOrder(Long orderId, boolean isApply) {

        OrderStatus changeOrderStatus = isApply? OrderStatus.RECEPTION : OrderStatus.CANCEL;

        //주문 상태 변경
        Order order = changeOrderStatus(orderId, changeOrderStatus);

        //고객 서비스에 주문 상태 업데이 트 요청
        Message requestUpdateOrderMessage = requestUpdateOrder(order.getCustomerOrderId(), changeOrderStatus);

        if(!requestUpdateOrderMessage.isOk()) {
            throw new OrderUpdateRequestFailedException("주문 정보 업데이트가 실패했습니다.");
        }

    }

    public Order changeOrderStatus(Long orderId, OrderStatus orderStatus){

        Order order = this.orderRepository.findById(orderId).orElseThrow(()->
                new OrderRequestFailedException("주문 정보가 일치 하지 않습니다.")
        );

        if (!order.getOrderStatus().equals(OrderStatus.ORDER)) {
            throw new OrderRequestFailedException("주문 상태가 일치 하지 않습니다.");
        }

        order.setOrderStatus(orderStatus);

        return this.orderRepository.save(order);
    }

    private Message requestUpdateOrder(Long orderId, OrderStatus orderStatus){

        CustomerOrderRequestDto dto = new CustomerOrderRequestDto();
        dto.setOrderId(orderId);
        dto.setOrderStatus(orderStatus);

        return customerClient.updateOrder(dto);
    }
}
