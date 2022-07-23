package com.example.demo.customers.controller;

import com.example.demo.customers.exception.CustomersIdNotFoundException;
import com.example.demo.customers.model.Customers;
import com.example.demo.customers.service.CustomersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomersController {
    final CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("/customers")
    public List<Customers> findAll() {
        return customersService.findAll();
    }

    @PostMapping("/createCustomers")
    public HttpStatus createCustomers(@RequestBody Customers customers) {
        customersService.createCustomers(customers);
        return HttpStatus.OK;
    }

    @PutMapping("/customers/{id}")
    public HttpStatus updateCustomers(@RequestBody Customers customers, @PathVariable Integer id) {
        try {
            Customers customersById = customersService.findById(id);
            customersService.updateCustomers(customersById, customers);
            return HttpStatus.NO_CONTENT;
        } catch (Exception ex) {
            throw new CustomersIdNotFoundException("No such customer by written id");
        }
    }

    @DeleteMapping("/customers/{id}")
    public HttpStatus deleteCustomers(@PathVariable Integer id) {
        try {
            Customers customersById = customersService.findById(id);
            customersService.deleteCustomers(customersById);
            return HttpStatus.NO_CONTENT;
        } catch (Exception ex) {
            throw new CustomersIdNotFoundException("No such customer by written id");
        }
    }
}
