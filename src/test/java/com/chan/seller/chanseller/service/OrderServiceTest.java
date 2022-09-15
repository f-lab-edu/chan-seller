package com.chan.seller.chanseller.service;

import com.chan.seller.chanseller.DatabaseTest;
import com.chan.seller.chanseller.domain.*;
import com.chan.seller.chanseller.dto.MenuDto;
import com.chan.seller.chanseller.dto.SellerDto;
import com.chan.seller.chanseller.dto.SellerOrderRequestDto;
import com.chan.seller.chanseller.dto.StoreDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class OrderServiceTest extends DatabaseTest {

    @Autowired
    OrderService orderService;

    @Autowired
    MenuService menuService;

    @Autowired
    StoreService storeService;

    @Autowired
    SellerService sellerService;

    @Test
    void requestOrder() {

        String accountId = "1qwe";
        Long customerId = 1L;
        Long customerOrderId = 1L;

        Seller seller = signUpSeller(accountId);

        Store store = signUpStore(accountId);

        Menu menu = registerMenu(store);

        SellerOrderRequestDto sellerOrderRequestDto = new SellerOrderRequestDto();

        sellerOrderRequestDto.setCustomerOrderId(customerOrderId);
        sellerOrderRequestDto.setCustomerId(customerId);
        sellerOrderRequestDto.setCustomerDoroAddress("도로명주소");
        sellerOrderRequestDto.setCustomerTelephone("010-1234-5678");
        sellerOrderRequestDto.setCustomerName("이름");
        sellerOrderRequestDto.setCustomerSigunguCode(1101111);
        sellerOrderRequestDto.setMenuCount(1);
        sellerOrderRequestDto.setMenuId(menu.getId());
        sellerOrderRequestDto.setMenuPlan("1010100");

        Order order = orderService.requestOrder(sellerOrderRequestDto);

        Assertions.assertEquals(order.getOrderStatus(),OrderStatus.ORDER);
        Assertions.assertEquals(order.getCustomerId(), customerId);

    }

    @Test
    void changeOrderStatus(){

        String accountId = "2qwe";
        Long customerId = 2L;
        Long customerOrderId = 2L;

        Seller seller = signUpSeller(accountId);

        Store store = signUpStore(accountId);

        Menu menu = registerMenu(store);

        SellerOrderRequestDto sellerOrderRequestDto = new SellerOrderRequestDto();

        sellerOrderRequestDto.setCustomerOrderId(customerOrderId);
        sellerOrderRequestDto.setCustomerId(customerId);
        sellerOrderRequestDto.setCustomerDoroAddress("도로명주소");
        sellerOrderRequestDto.setCustomerTelephone("010-1234-5678");
        sellerOrderRequestDto.setCustomerName("이름");
        sellerOrderRequestDto.setCustomerSigunguCode(1101111);
        sellerOrderRequestDto.setMenuCount(1);
        sellerOrderRequestDto.setMenuId(menu.getId());
        sellerOrderRequestDto.setMenuPlan("1010100");

        Order order = orderService.requestOrder(sellerOrderRequestDto);

        order = orderService.changeOrderStatus(order.getId(), OrderStatus.RECEPTION);

        Assertions.assertEquals(order.getOrderStatus(), OrderStatus.RECEPTION);

    }

    private Menu registerMenu(Store store){

        MenuDto menuDto = new MenuDto();
        menuDto.setName("이름");
        menuDto.setDescription("description");
        menuDto.setPrice(1000);
        menuDto.setStoreId(store.getId());

        Menu menu = menuService.registerMenu(menuDto);

        return menu;
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