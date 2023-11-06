package com.example.enoca_backend_challenge_soru5.service;

import com.example.enoca_backend_challenge_soru5.generic.GenericResponse;
import com.example.enoca_backend_challenge_soru5.model.Customer;
import com.example.enoca_backend_challenge_soru5.model.DTO.CustomResponse;
import com.example.enoca_backend_challenge_soru5.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomService {
    private final CustomerService customerService;
    private final OrderService orderService;

    public GenericResponse<List<CustomResponse>> searchCustomerAndOrdersByKeyword(String keyword) {
        List<Customer> customerList = customerService.searchCustomerAndOrdersByKeyword(keyword);
        List<CustomResponse> customResponses = new ArrayList<>();

        for (Customer customers : customerList) {
            customResponses.add(new CustomResponse(
                    customers.getName(),
                    customers.getAge(),
                    orderService.showOrdersByCustomerId(customers.getId()).stream().map(
                            Order::getId
                    ).collect(Collectors.toList())
            ));
        }
        return new GenericResponse<>(customResponses,Boolean.TRUE);


    }
}
