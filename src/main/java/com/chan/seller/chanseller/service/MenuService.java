package com.chan.seller.chanseller.service;

import com.chan.seller.chanseller.domain.Menu;
import com.chan.seller.chanseller.domain.Store;
import com.chan.seller.chanseller.dto.MenuDto;
import com.chan.seller.chanseller.repository.MenuRepository;
import com.chan.seller.chanseller.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final StoreRepository storeRepository;

    private final MenuRepository menuRepository;

    @Transactional
    public Menu registerMenu(MenuDto menuDto) {
        Store store = this.storeRepository.findById(menuDto.getStoreId());
        Menu menu = new Menu();
        menu.setName(menuDto.getName());
        menu.setDescription(menuDto.getDescription());
        menu.setPrice(menuDto.getPrice());
        menu.setStore(store);
        store.addMenu(menu);

        this.storeRepository.save(store);
        this.menuRepository.save(menu);

        return menu;
    }
}
