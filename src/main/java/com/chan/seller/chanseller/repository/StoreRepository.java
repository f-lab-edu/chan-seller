package com.chan.seller.chanseller.repository;

import com.chan.seller.chanseller.domain.Store;
import org.springframework.data.repository.Repository;

public interface StoreRepository extends Repository<Store, Integer> {

    void save(Store store);

    Store findById(Long id);
}
