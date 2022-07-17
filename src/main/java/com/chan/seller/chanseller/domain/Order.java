package com.chan.seller.chanseller.domain;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "orders")
public class Order extends NameEntity {

    @Embedded
    private Address address;

    @Column(name = "telephone", length = 12)
    @NotEmpty
    @Digits(fraction = 0, integer = 11)
    private String telephone;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Column(name = "plan", length = 25)
    @NotEmpty
    private String plan;

    @Column(name = "customer_id")
    private Long customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
