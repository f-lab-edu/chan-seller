package com.chan.seller.chanseller.controller;

import com.chan.seller.chanseller.client.CustomerClient;
import com.chan.seller.chanseller.common.Message;
import com.chan.seller.chanseller.common.StatusEnum;
import com.chan.seller.chanseller.domain.Order;
import com.chan.seller.chanseller.domain.OrderStatusEnum;
import com.chan.seller.chanseller.dto.CustomerOrderRequestDto;
import com.chan.seller.chanseller.dto.SellerOrderRequestDto;
import com.chan.seller.chanseller.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/seller/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Message requestOrder(@RequestBody SellerOrderRequestDto sellerOrderRequestDto) {
        Message message = new Message();
        orderService.convertDtoToOrder(sellerOrderRequestDto);

        message.setStatus(StatusEnum.OK);
        message.setMessage("OK");

        return message;
    }

    @GetMapping("/apply")
    public String applyOrder(@RequestParam(name = "orderId", defaultValue = "0") Long id) {
        Message message = orderService.ProcessOrder(id, true);
        return message.getMessage();
    }

    @GetMapping("/cancel")
    public String cancelOrder(@RequestParam(name = "orderId", defaultValue = "0") Long id) {
        Message message = orderService.ProcessOrder(id, false);
        return message.getMessage();
    }
}
