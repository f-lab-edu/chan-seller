package com.chan.seller.chanseller.dto;

import com.chan.seller.chanseller.domain.Address;
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
    private String customerName;

    @NotEmpty
    private Address customerAddress;

    @NotEmpty
    private String customerTelephone;

    @NotEmpty
    private Long menuId;

    @NotEmpty
    private String menuPlan;

    @NotEmpty
    private int menuCount;
}
