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
    @NotEmpty(message = "customerId가 필요합니다.")
    private Long customerId;

    @NotEmpty(message = "customerOrderId가 필요합니다.")
    private Long customerOrderId;

    @NotEmpty(message = "customerName가 필요합니다.")
    private String customerName;

    @NotEmpty(message = "customerDoroAddress가 필요합니다.")
    private String customerDoroAddress;

    @NotEmpty(message = "customerSigunguCode가 필요합니다.")
    private int customerSigunguCode;

    @NotEmpty(message = "customerTelephone가 필요합니다.")
    private String customerTelephone;

    @NotEmpty(message = "menuId가 필요합니다.")
    private Long menuId;

    @NotEmpty(message = "menuPlan가 필요합니다.")
    private String menuPlan;

    @NotEmpty(message = "menuCount가 필요합니다.")
    private int menuCount;
}
