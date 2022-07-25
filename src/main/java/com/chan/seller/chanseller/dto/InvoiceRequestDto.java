package com.chan.seller.chanseller.dto;

import com.chan.seller.chanseller.domain.Address;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class InvoiceRequestDto {

    @NotNull
    private Long orderId;

    @NotNull
    private LocalDate deliveryDate;

    @NotNull
    private boolean meridiem; //0: am 1: pm

    @NotNull @Valid
    private Address storeAddress;

    @NotNull @Valid
    private Address customerAddress;
}