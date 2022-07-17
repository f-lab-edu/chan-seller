package com.chan.seller.chanseller.controller;

import com.chan.seller.chanseller.common.Message;
import com.chan.seller.chanseller.common.StatusEnum;
import com.chan.seller.chanseller.dto.SellerOrderRequestDto;
import com.chan.seller.chanseller.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/seller")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public Message requestOrder(@RequestBody SellerOrderRequestDto sellerOrderRequestDto) {
        Message message = new Message();
        orderService.convertDtoToOrder(sellerOrderRequestDto);

        message.setStatus(StatusEnum.OK);
        message.setMessage("성공");

        return message;
    }
}
