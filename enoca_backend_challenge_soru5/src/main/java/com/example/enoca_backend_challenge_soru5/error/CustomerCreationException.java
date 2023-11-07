package com.example.enoca_backend_challenge_soru5.error;

public class CustomerCreationException extends RuntimeException {
    public CustomerCreationException() {
        super("Customer could not be created !!!");
    }
}

