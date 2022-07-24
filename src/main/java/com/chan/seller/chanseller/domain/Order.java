package com.chan.seller.chanseller.domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "orders")
public class Order extends NameEntity {

    @Embedded
    private Address address;

    @Column(name = "telephone", length = 12)
    @NotEmpty
    private String telephone;

    @Column(name = "customer_order_id")
    private Long customerOrderId;

    @Column(name = "start_date")
    @NotNull
    private LocalDate startDate;

    @Column(name = "end_date")
    @NotNull
    private LocalDate endDate;

    @Column(name = "plan", length = 25)
    @NotEmpty
    private String plan;

    @Column(name = "status", length = 20)
    @NotEmpty
    private String status;

    @Column(name = "customer_id")
    private Long customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public void setCustomerOrderId(Long customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

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
