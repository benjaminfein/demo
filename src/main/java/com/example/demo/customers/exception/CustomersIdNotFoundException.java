package com.example.demo.customers.exception;

public class CustomersIdNotFoundException extends RuntimeException{
    public CustomersIdNotFoundException(String message) {
        super(message);
    }
}
