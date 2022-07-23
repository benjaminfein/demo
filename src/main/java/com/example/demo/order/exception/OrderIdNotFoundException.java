package com.example.demo.order.exception;

public class OrderIdNotFoundException extends RuntimeException{
    public OrderIdNotFoundException(String message) {
        super(message);
    }
}
