package com.chan.seller.chanseller.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
@NoArgsConstructor @AllArgsConstructor
@Getter
public class Address {

    @Column(name = "doro_address", length = 100)
    @NotEmpty
    private String doroAddress;

    @Column(name = "sigungu_code")
    @NotEmpty
    private int sigunguCode;

}
