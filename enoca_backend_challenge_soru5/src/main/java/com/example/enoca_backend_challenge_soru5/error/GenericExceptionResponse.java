package com.example.enoca_backend_challenge_soru5.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class GenericExceptionResponse {
    private String errorMessage;
    private Date errorDate;
}
