package com.chan.seller.chanseller.domain;

import com.chan.seller.chanseller.dto.SellerOrderRequestDto;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "orders")
public class Order extends NameEntity {

    @Embedded
    private Address address;

    @Column(name = "telephone", length = 13)
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

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "customer_id")
    private Long customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public static Order request(SellerOrderRequestDto dto, Menu menu){
        Order order = new Order();

        order.setCustomerId(dto.getCustomerId());
        order.setCustomerOrderId(dto.getCustomerOrderId());
        order.setName(dto.getCustomerName());
        order.setTelephone(dto.getCustomerTelephone());
        order.setPlan(dto.getMenuPlan());
        order.setOrderStatus(OrderStatus.ORDER);

        order.setStartDate(LocalDate.now());
        order.setEndDate(LocalDate.now());

        //주소 설정
        Address address = new Address();
        address.setDoroAddress(dto.getCustomerDoroAddress());
        address.setSigunguCode(dto.getCustomerSigunguCode());

        order.setAddress(address);

        //메뉴 설정
        menu.addOrder(order);

        return order;
    }

    public void setCustomerOrderId(Long customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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
