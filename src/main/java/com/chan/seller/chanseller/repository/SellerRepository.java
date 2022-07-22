package com.chan.seller.chanseller.repository;

import com.chan.seller.chanseller.domain.Seller;
import org.springframework.data.repository.Repository;

public interface SellerRepository extends Repository<Seller, Integer> {
    void save(Seller seller);

    Seller findByAccountId(String accountId);
}
