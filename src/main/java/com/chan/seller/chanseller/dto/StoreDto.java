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
public class StoreDto {

    @NotEmpty(message = "accountId가 필요합니다.")
    private String accountId;

    @NotEmpty(message = "name가 필요합니다.")
    private String name;

    @NotEmpty(message = "telephone가 필요합니다.")
    private String telephone;

    @NotEmpty(message = "address가 필요합니다.")
    private Address address;
}
