package com.example.demo.products.exception;

public class ProductsIdNotFoundException extends RuntimeException {
    public ProductsIdNotFoundException(String message) {
        super(message);
    }
}
