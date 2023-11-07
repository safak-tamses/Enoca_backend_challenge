package com.example.enoca_backend_challenge_soru5.error;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException() {
        super("Customer not found!!!");
    }
}
