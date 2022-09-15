package com.chan.seller.chanseller.service;

import com.chan.seller.chanseller.DatabaseTest;
import com.chan.seller.chanseller.domain.Address;
import com.chan.seller.chanseller.domain.Menu;
import com.chan.seller.chanseller.domain.Seller;
import com.chan.seller.chanseller.domain.Store;
import com.chan.seller.chanseller.dto.MenuDto;
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
class MenuServiceTest extends DatabaseTest {

    @Autowired
    MenuService menuService;

    @Autowired
    StoreService storeService;

    @Autowired
    SellerService sellerService;

    @Test
    void registerMenu() {

        String accountId = "12345678";

        Seller seller = signUpSeller(accountId);

        Store store = signUpStore(accountId);

        MenuDto menuDto = new MenuDto();
        menuDto.setName("이름");
        menuDto.setDescription("description");
        menuDto.setPrice(1000);
        menuDto.setStoreId(store.getId());

        Menu menu = menuService.registerMenu(menuDto);

        Assertions.assertEquals(menu.getStore().getId(), store.getId());
        Assertions.assertEquals(menu.getName(), menuDto.getName());
        Assertions.assertEquals(menu.getPrice(), menuDto.getPrice());

    }

    private Store signUpStore(String accountId){

        Address address = new Address();
        address.setDoroAddress("서울시 종로구");
        address.setSigunguCode(11110);

        StoreDto storeDto = new StoreDto();
        storeDto.setTelephone("010-1234-1234");
        storeDto.setAddress(address);
        storeDto.setName("가게 이름");
        storeDto.setAccountId(accountId);

        Store store = storeService.registerStore(storeDto);

        return store;

    }

    private Seller signUpSeller(String accountId){
        SellerDto sellerDto = new SellerDto();
        sellerDto.setName("이름");
        sellerDto.setAccountId(accountId);
        sellerDto.setTelephone("010-1234-1234");

        return sellerService.signUp(sellerDto);
    }
}