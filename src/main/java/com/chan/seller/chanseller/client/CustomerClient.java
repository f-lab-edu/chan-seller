package com.chan.seller.chanseller.client;

import com.chan.seller.chanseller.common.Message;
import com.chan.seller.chanseller.dto.CustomerOrderRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="customer", url="${customer.ribbon.listOfServers}")
public interface CustomerClient {

    @PutMapping("/customer/order")
    Message updateOrder(@RequestBody CustomerOrderRequestDto customerOrderRequestDto);
}
