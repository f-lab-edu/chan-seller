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

    private Long customerId;

    private Long customerOrderId;

    @NotEmpty(message = "customerName가 필요합니다.")
    private String customerName;

    @NotEmpty(message = "customerDoroAddress가 필요합니다.")
    private String customerDoroAddress;

    private int customerSigunguCode;

    @NotEmpty(message = "customerTelephone가 필요합니다.")
    private String customerTelephone;

    private Long menuId;

    @NotEmpty(message = "menuPlan가 필요합니다.")
    private String menuPlan;

    private int menuCount;
}
