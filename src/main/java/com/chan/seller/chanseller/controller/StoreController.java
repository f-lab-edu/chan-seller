package com.chan.seller.chanseller.controller;

import com.chan.seller.chanseller.common.Message;
import com.chan.seller.chanseller.common.StatusEnum;
import com.chan.seller.chanseller.domain.Store;
import com.chan.seller.chanseller.dto.StoreDto;
import com.chan.seller.chanseller.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/seller/store")
public class StoreController {

    private final StoreService storeService;

    @PostMapping(value = "/register")
    public ResponseEntity<Message> registerStore(@Valid @RequestBody StoreDto storeDto) {
        Message message = new Message();
        Store store = storeService.registerStore(storeDto);

        message.setStatus(StatusEnum.OK);
        message.setMessage("가게 등록 완료");
        message.setData(store);

        return ResponseEntity.ok().body(message);
    }
}
