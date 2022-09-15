package com.chan.seller.chanseller.service;

import com.chan.seller.chanseller.domain.Seller;
import com.chan.seller.chanseller.domain.Store;
import com.chan.seller.chanseller.dto.StoreDto;
import com.chan.seller.chanseller.repository.SellerRepository;
import com.chan.seller.chanseller.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    private final SellerRepository sellerRepository;

    @Transactional
    public Store registerStore(StoreDto storeDto) {
        Seller seller = this.sellerRepository.findByAccountId(storeDto.getAccountId());

        if (seller == null) {
            throw new RuntimeException();
        }

        Store store = new Store();
        store.setName(storeDto.getName());
        store.setTelephone(storeDto.getTelephone());
        store.setAddress(storeDto.getAddress());
        store.setSeller(seller);

        seller.setStore(store);

        this.storeRepository.save(store);
        return store;
    }
}
