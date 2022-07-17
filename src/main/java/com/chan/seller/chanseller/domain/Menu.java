package com.chan.seller.chanseller.domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "menus")
public class Menu extends NameEntity {

    @Column(name = "description")
    @NotEmpty
    private String description;

    @Column(name = "price")
    @NotEmpty
    private int price;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id")
    private Store store;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
