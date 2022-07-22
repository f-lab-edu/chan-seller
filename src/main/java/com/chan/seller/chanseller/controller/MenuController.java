package com.chan.seller.chanseller.controller;

import com.chan.seller.chanseller.common.Message;
import com.chan.seller.chanseller.common.StatusEnum;
import com.chan.seller.chanseller.domain.Menu;
import com.chan.seller.chanseller.dto.MenuDto;
import com.chan.seller.chanseller.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/seller/menu")
public class MenuController {

    private final MenuService menuService;

    @PostMapping(value = "/register")
    public ResponseEntity<Message> registerMenu(@Valid @RequestBody MenuDto menuDto) {
        Message message = new Message();
        Menu menu = menuService.registerMenu(menuDto);

        message.setStatus(StatusEnum.OK);
        message.setMessage("메뉴 등록 완료");
        message.setData(menu);

        return ResponseEntity.ok().body(message);
    }
}
