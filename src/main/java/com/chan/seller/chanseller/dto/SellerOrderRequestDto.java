package com.chan.seller.chanseller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SellerOrderRequestDto {
    @NotEmpty
    private Long customerId;

    @NotEmpty
    private Long customerOrderId;

    @NotEmpty
    private String customerName;

    @NotEmpty
    private String customerDoroAddress;

    @NotEmpty
    private int customerSigunguCode;

    @NotEmpty
    private String customerTelephone;

    @NotEmpty
    private Long menuId;

    @NotEmpty
    private String menuPlan;

    @NotEmpty
    private int menuCount;
}
