package com.chan.seller.chanseller.service;

import com.chan.seller.chanseller.DatabaseTest;
import com.chan.seller.chanseller.domain.Address;
import com.chan.seller.chanseller.domain.Seller;
import com.chan.seller.chanseller.domain.Store;
import com.chan.seller.chanseller.dto.SellerDto;
import com.chan.seller.chanseller.dto.StoreDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class StoreServiceTest extends DatabaseTest {

    @Autowired
    StoreService storeService;

    @Autowired
    SellerService sellerService;

    @Test
    public void registerStore(){

        Seller seller = sellerSignUp();

        Address address = new Address();
        address.setDoroAddress("aaaaa");
        address.setSigunguCode(1110);

        StoreDto storeDto = new StoreDto();
        storeDto.setAccountId("12345678");
        storeDto.setAddress(address);
        storeDto.setName("이름");
        storeDto.setTelephone("010-1234-1234");

        Store store = storeService.registerStore(storeDto);

        Assertions.assertEquals(store.getSeller(), seller);

    }

    private Seller sellerSignUp(){

        SellerDto sellerDto = new SellerDto();
        sellerDto.setName("이름");
        sellerDto.setAccountId("12345678");
        sellerDto.setTelephone("010-1234-1234");

        return sellerService.signUp(sellerDto);

    }

}