package com.chan.seller.chanseller.repository;

import com.chan.seller.chanseller.domain.Menu;
import org.springframework.data.repository.Repository;

public interface MenuRepository extends Repository<Menu, Integer> {
    void save(Menu menu);

    Menu findById(Long id);
}
