package com.chan.seller.chanseller.service;

import com.chan.seller.chanseller.client.CustomerClient;
import com.chan.seller.chanseller.common.Message;
import com.chan.seller.chanseller.domain.Address;
import com.chan.seller.chanseller.domain.Order;
import com.chan.seller.chanseller.dto.CustomerOrderRequestDto;
import com.chan.seller.chanseller.dto.SellerOrderRequestDto;
import com.chan.seller.chanseller.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;

    private final OrderRepository orderRepository;

    @Transactional
    public void convertDtoToOrder(SellerOrderRequestDto dto) {
        Order order = new Order();
        order.setCustomerId(dto.getCustomerId());
        order.setName(dto.getCustomerName());
        order.setTelephone(dto.getCustomerTelephone());
        order.setPlan(dto.getMenuPlan());
        order.setStatus("ORDER");

        order.setStartDate(LocalDate.now());
        order.setEndDate(LocalDate.now());

        Address address = new Address();
        address.setDoroAddress(dto.getCustomerDoroAddress());
        address.setSigunguCode(dto.getCustomerSigunguCode());
        order.setAddress(address);

        this.orderRepository.save(order);
    }

    @Transactional
    public Message ProcessOrder(Long id, boolean isApply) {
        Message message = new Message();
        Order order = this.orderRepository.findById(id);

        if (order == null) {
            message.setMessage("주문이 존재하지 않습니다.");
            return message;
        }

        if (!order.getStatus().equals("ORDER")) {
            message.setMessage("이미 수락, 취소된 주문입니다.");
            return message;
        }

        CustomerOrderRequestDto dto = new CustomerOrderRequestDto();
        dto.setOrderId(id);

        if (isApply) {
            dto.setOrderStatus("RECEPTION");
            order.setStatus("RECEPTION");
        } else {
            dto.setOrderStatus("CANCEL");
            order.setStatus("CANCEL");
        }

        message = customerClient.updateOrder(dto);
        this.orderRepository.save(order);
        return message;
    }
}
