package com.example.enoca_backend_challenge_soru5.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class OrderCreateRequest {
    private Long customerId;
    private Double totalPrice;
}
