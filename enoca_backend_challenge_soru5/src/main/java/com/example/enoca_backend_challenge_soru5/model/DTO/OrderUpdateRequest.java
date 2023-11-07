package com.example.enoca_backend_challenge_soru5.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderUpdateRequest {
    private Long customerId;
    private Double totalPrice;
}
