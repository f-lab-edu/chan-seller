package com.chan.seller.chanseller.repository;

import com.chan.seller.chanseller.domain.Order;
import org.springframework.data.repository.Repository;

public interface OrderRepository extends Repository<Order, Integer> {
    void save(Order order);

    Order findById(Long id);
}
