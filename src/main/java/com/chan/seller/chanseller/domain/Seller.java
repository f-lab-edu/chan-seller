package com.chan.seller.chanseller.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
@Getter
public class Seller extends NameEntity{
    @NotEmpty
    @Column(name = "account_id")
    private String accountId;

    @Column(name = "telephone", length = 13)
    @NotEmpty
    private String telephone;

    @OneToOne(mappedBy = "seller")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return getAccountId().equals(seller.getAccountId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountId());
    }
}
