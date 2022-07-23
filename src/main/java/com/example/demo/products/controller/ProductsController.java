package com.example.demo.products.controller;

import com.example.demo.products.exception.ProductsIdNotFoundException;
import com.example.demo.products.model.Products;
import com.example.demo.products.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {
    final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products")
    public List<Products> findAll() {
        return productsService.findAll();
    }

    @PostMapping("/createProducts")
    public HttpStatus createProducts(@RequestBody Products products) {
        productsService.createProducts(products);
        return HttpStatus.OK;
    }

    @PutMapping("/products/{id}")
    public HttpStatus updateProducts(@RequestBody Products products, @PathVariable Integer id) {
        try {
            Products productsById = productsService.findById(id);
            productsService.updateProducts(productsById, products);
            return HttpStatus.NO_CONTENT;
        } catch (Exception ex) {
            throw new ProductsIdNotFoundException("No such product by written id");
        }
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus deleteProducts(@PathVariable Integer id) {
        try {
            Products productsById = productsService.findById(id);
            productsService.deleteProducts(productsById);
            return HttpStatus.NO_CONTENT;
        } catch (Exception ex) {
            throw new ProductsIdNotFoundException("No such product by written id");
        }
    }
}
