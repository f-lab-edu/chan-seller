package com.chan.seller.chanseller.domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "stores")
public class Store extends NameEntity {

    @Embedded
    private Address address;

    @Column(name = "telephone", length = 12)
    @NotEmpty
    private String telephone;

    @OneToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();


    public void setAddress(Address address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void addMenu(Menu menu) {
        menu.setStore(this);
        this.menus.add(menu);
    }
}
