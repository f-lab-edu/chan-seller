package com.chan.seller.chanseller.controller;

import com.chan.seller.chanseller.common.Message;
import com.chan.seller.chanseller.common.StatusEnum;
import com.chan.seller.chanseller.domain.Order;
import com.chan.seller.chanseller.dto.SellerOrderRequestDto;
import com.chan.seller.chanseller.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/seller/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Message> requestOrder(@Valid @RequestBody SellerOrderRequestDto sellerOrderRequestDto) {
        Message message = new Message();
        Order order = orderService.convertDtoToOrder(sellerOrderRequestDto);

        if (order == null) {
            message.setStatus(StatusEnum.BAD_REQUEST);
            message.setMessage("FAIL");
        } else {
            message.setStatus(StatusEnum.OK);
            message.setMessage("OK");
        }
        message.setData(order);

        return ResponseEntity.ok().body(message);
    }

    @PostMapping("/apply")
    public ResponseEntity<Message> applyOrder(@RequestParam(name = "orderId", defaultValue = "0") Long id) {
        Message message = orderService.ProcessOrder(id, true);
        return ResponseEntity.ok().body(message);
    }

    @PostMapping("/cancel")
    public ResponseEntity<Message> cancelOrder(@RequestParam(name = "orderId", defaultValue = "0") Long id) {
        Message message = orderService.ProcessOrder(id, false);
        return ResponseEntity.ok().body(message);
    }
}
