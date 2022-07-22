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
public class SellerDto {
    @NotEmpty(message = "accountId가 필요합니다.")
    private String accountId;

    @NotEmpty(message = "name가 필요합니다.")
    private String name;

    @NotEmpty(message = "telephone가 필요합니다.")
    private String telephone;
}
