package com.chan.seller.chanseller.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
public class Seller extends NameEntity{
    @NotEmpty
    @Column(name = "account_id")
    private String accountId;

    @Column(name = "telephone", length = 12)
    @NotEmpty
    private String telephone;

    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
