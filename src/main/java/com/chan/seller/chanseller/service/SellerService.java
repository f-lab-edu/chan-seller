package com.chan.seller.chanseller.service;

import com.chan.seller.chanseller.domain.Seller;
import com.chan.seller.chanseller.dto.SellerDto;
import com.chan.seller.chanseller.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;

    @Transactional
    public Seller signUp(SellerDto sellerDto) {
        Seller seller = new Seller();
        seller.setAccountId(sellerDto.getAccountId());
        seller.setName(sellerDto.getName());
        seller.setTelephone(sellerDto.getTelephone());

        this.sellerRepository.save(seller);
        return seller;
    }
}
