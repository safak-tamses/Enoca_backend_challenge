package com.example.enoca_backend_challenge_soru5.error;

public class OrderDatabaseException extends RuntimeException{
    public OrderDatabaseException() {
        super("Something gone wrong!!!");
    }
}
