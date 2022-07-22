package com.chan.seller.chanseller.controller;

import com.chan.seller.chanseller.common.Message;
import com.chan.seller.chanseller.common.StatusEnum;
import com.chan.seller.chanseller.domain.Seller;
import com.chan.seller.chanseller.dto.SellerDto;
import com.chan.seller.chanseller.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/seller")
public class SellerController {

    private final SellerService sellerService;

    @PostMapping("/signUp")
    public ResponseEntity<Message> signUp(@Valid @RequestBody SellerDto sellerDto) {
        Message message = new Message();

        Seller seller = sellerService.signUp(sellerDto);
        message.setStatus(StatusEnum.OK);
        message.setMessage("회원가입 완료");
        message.setData(seller);

        return ResponseEntity.ok().body(message);
    }
}
