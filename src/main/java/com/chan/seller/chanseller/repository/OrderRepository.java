package com.chan.seller.chanseller.repository;

import com.chan.seller.chanseller.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
