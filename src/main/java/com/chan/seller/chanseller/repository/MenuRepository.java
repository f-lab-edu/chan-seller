package com.chan.seller.chanseller.repository;

import com.chan.seller.chanseller.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
