package com.example.enoca_backend_challenge_soru5.controller;

import com.example.enoca_backend_challenge_soru5.generic.GenericResponse;
import com.example.enoca_backend_challenge_soru5.model.DTO.CustomerCreateRequest;
import com.example.enoca_backend_challenge_soru5.model.DTO.CustomerUpdateRequest;
import com.example.enoca_backend_challenge_soru5.model.DTO.OrderUpdateRequest;
import com.example.enoca_backend_challenge_soru5.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<GenericResponse> customerCreate(@RequestBody CustomerCreateRequest customerCreateRequest) {
        return new ResponseEntity<>(customerService.createCustomer(customerCreateRequest), HttpStatus.OK);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<GenericResponse> customerShow(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.showCustomer(id), HttpStatus.OK);
    }

    @GetMapping("/show/all")
    public ResponseEntity<GenericResponse> customerShowAll() {
        return new ResponseEntity<>(customerService.showAllCustomers(), HttpStatus.OK);
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<GenericResponse> customerUpdate(@PathVariable Long customerId, @RequestBody CustomerUpdateRequest customerUpdateRequest) {
        return new ResponseEntity<>(customerService.updateCustomer(customerUpdateRequest, customerId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponse> customerDelete(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<GenericResponse> customerDeleteAll() {
        return new ResponseEntity<>(customerService.deleteAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/show/without-order")
    public ResponseEntity<GenericResponse> customerShowWithoutOrder() {
        return new ResponseEntity<>(customerService.showCustomerWithoutOrder(), HttpStatus.OK);
    }
}
