package com.example.enoca_backend_challenge_soru5.error;

public class OrderCreationException extends RuntimeException{
    public OrderCreationException() {
        super("Order could not be created !!!");
    }
}
