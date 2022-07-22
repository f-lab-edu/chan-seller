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
public class MenuDto {
    @NotEmpty(message = "storeId가 필요합니다.")
    private Long storeId;

    @NotEmpty(message = "name가 필요합니다.")
    private String name;

    @NotEmpty(message = "description가 필요합니다.")
    private String description;

    @NotEmpty(message = "price가 필요합니다.")
    private int price;
}
