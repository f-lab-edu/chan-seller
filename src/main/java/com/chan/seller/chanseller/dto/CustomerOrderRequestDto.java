package com.chan.seller.chanseller.dto;

import com.chan.seller.chanseller.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerOrderRequestDto {
    @NotEmpty
    private Long orderId;

    @NotEmpty
    private OrderStatus orderStatus;
}
