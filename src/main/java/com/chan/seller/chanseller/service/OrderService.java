package com.chan.seller.chanseller.service;

import com.chan.seller.chanseller.client.CustomerClient;
import com.chan.seller.chanseller.common.Message;
import com.chan.seller.chanseller.common.StatusEnum;
import com.chan.seller.chanseller.domain.Address;
import com.chan.seller.chanseller.domain.Menu;
import com.chan.seller.chanseller.domain.Order;
import com.chan.seller.chanseller.dto.CustomerOrderRequestDto;
import com.chan.seller.chanseller.dto.SellerOrderRequestDto;
import com.chan.seller.chanseller.repository.MenuRepository;
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

    private final MenuRepository menuRepository;

    @Transactional
    public Order convertDtoToOrder(SellerOrderRequestDto dto) {
        Menu menu = this.menuRepository.findById(dto.getMenuId());

        if (menu == null) {
            throw new RuntimeException();
        }

        Order order = new Order();
        order.setCustomerId(dto.getCustomerId());
        order.setCustomerOrderId(dto.getCustomerOrderId());
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
        order.setMenu(menu);
        menu.addOrder(order);

        this.orderRepository.save(order);
        return order;
    }

    @Transactional
    public Message ProcessOrder(Long id, boolean isApply) {
        Message message = new Message();
        Order order = this.orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException();
        }

        if (!order.getStatus().equals("ORDER")) {
            throw new RuntimeException();
        }

        CustomerOrderRequestDto dto = new CustomerOrderRequestDto();
        dto.setOrderId(order.getCustomerOrderId());

        if (isApply) {
            dto.setOrderStatus("RECEPTION");
            order.setStatus("RECEPTION");
        } else {
            dto.setOrderStatus("CANCEL");
            order.setStatus("CANCEL");
        }

        this.orderRepository.save(order);
        message = customerClient.updateOrder(dto);

        if(message.getStatus().equals(StatusEnum.BAD_REQUEST)) {
            throw new RuntimeException();
        }
        return message;
    }
}
