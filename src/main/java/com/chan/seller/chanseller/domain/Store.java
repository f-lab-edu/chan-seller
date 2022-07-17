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
    @Digits(fraction = 0, integer = 11)
    @NotEmpty
    private String telephone;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();


    public void setAddress(Address address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
