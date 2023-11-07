package com.example.enoca_backend_challenge_soru5.error;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException() {
        super("Customer not found!!!");
    }
}
