package com.chan.seller.chanseller.service;

import com.chan.seller.chanseller.domain.Address;
import com.chan.seller.chanseller.domain.Order;
import com.chan.seller.chanseller.dto.SellerOrderRequestDto;
import com.chan.seller.chanseller.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public void convertDtoToOrder(SellerOrderRequestDto dto) {
        Order order = new Order();
        order.setCustomerId(dto.getCustomerId());
        order.setName(dto.getCustomerName());
        order.setAddress(dto.getCustomerAddress());
        order.setTelephone(dto.getCustomerTelephone());
        order.setPlan(dto.getMenuPlan());
        this.orderRepository.save(order);
    }
}
