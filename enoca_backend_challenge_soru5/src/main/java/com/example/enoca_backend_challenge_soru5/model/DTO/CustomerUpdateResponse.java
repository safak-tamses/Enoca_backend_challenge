package com.example.enoca_backend_challenge_soru5.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerUpdateResponse {
    private String name;
    private Integer age;
    private String message;
}
