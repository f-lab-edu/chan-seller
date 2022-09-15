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

        Order order = orderService.requestOrder(sellerOrderRequestDto);

        message.setStatus(StatusEnum.OK);
        message.setMessage("주문 요청 성공");
        message.setData(order);

        return ResponseEntity.ok().body(message);
    }

    @PostMapping("/apply")
    public ResponseEntity<Message> applyOrder(@RequestParam(name = "orderId", defaultValue = "0") Long id) {
        Message message = new Message();

        orderService.ProcessOrder(id, true);

        message.setStatus(StatusEnum.OK);
        message.setMessage("주문 승인 성공");

        return ResponseEntity.ok().body(message);
    }

    @PostMapping("/cancel")
    public ResponseEntity<Message> cancelOrder(@RequestParam(name = "orderId", defaultValue = "0") Long id) {
        Message message = new Message();

        orderService.ProcessOrder(id, false);

        message.setStatus(StatusEnum.OK);
        message.setMessage("주문 취소 성공");

        return ResponseEntity.ok().body(message);
    }
}
