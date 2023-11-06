package com.example.enoca_backend_challenge_soru5.controller;

import com.example.enoca_backend_challenge_soru5.generic.GenericResponse;
import com.example.enoca_backend_challenge_soru5.model.DTO.OrderCreateRequest;
import com.example.enoca_backend_challenge_soru5.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<GenericResponse> orderCreate(@RequestBody OrderCreateRequest orderCreateRequest) {
        return new ResponseEntity<>(orderService.createOrder(orderCreateRequest), HttpStatus.OK);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<GenericResponse> orderShow(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.showOrder(id), HttpStatus.OK);
    }

    @GetMapping("/show/all")
    public ResponseEntity<GenericResponse> orderShowAll() {
        return new ResponseEntity<>(orderService.showAllOrders(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponse> customerDelete(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.deleteOrder(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<GenericResponse> customerDeleteAll() {
        return new ResponseEntity<>(orderService.deleteAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/show/after-date")
    public ResponseEntity<GenericResponse> customerShowByAfterDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Date date) {
        return new ResponseEntity<>(orderService.listOrdersCreatedAfterDate(date), HttpStatus.OK);
    }
}
