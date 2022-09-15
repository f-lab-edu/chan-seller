package com.chan.seller.chanseller.service;

import com.chan.seller.chanseller.DatabaseTest;
import com.chan.seller.chanseller.domain.Seller;
import com.chan.seller.chanseller.dto.SellerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SellerServiceTest extends DatabaseTest {

    @Autowired
    SellerService sellerService;

    @Test
    void signUp() {

        SellerDto sellerDto = new SellerDto();
        sellerDto.setName("이름");
        sellerDto.setAccountId("12345678");
        sellerDto.setTelephone("010-1234-1234");

        Seller seller = sellerService.signUp(sellerDto);

        Assertions.assertEquals(seller.getAccountId(), sellerDto.getAccountId());

    }
}