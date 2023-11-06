package com.example.enoca_backend_challenge_soru5.controller;

import com.example.enoca_backend_challenge_soru5.generic.GenericResponse;
import com.example.enoca_backend_challenge_soru5.service.CustomService;
import com.example.enoca_backend_challenge_soru5.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/custom")

public class CustomController {
    private final CustomService customService;

    @GetMapping("/show/{keyword}")
    public ResponseEntity<GenericResponse> customerShow(@PathVariable String keyword) {
        return new ResponseEntity<>(customService.searchCustomerAndOrdersByKeyword(keyword), HttpStatus.OK);
    }
}
