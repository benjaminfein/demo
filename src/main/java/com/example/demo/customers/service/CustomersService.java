package com.example.demo.customers.service;

import com.example.demo.customers.model.Customers;
import com.example.demo.customers.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService extends Customers {
    @Autowired
    public CustomersRepository customersRepository;

    public List<Customers> findAll() {
        return customersRepository.findAll();
    }

    public void createCustomers(Customers customers) {
        customersRepository.save(customers);
    }

    public Customers findById(Integer id) {
        return customersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such customer by id: " + id));
    }

    public void updateCustomers(Customers exitingCustomers, Customers customersForUpdate) {
        exitingCustomers.setId(customersForUpdate.getId());
        exitingCustomers.setName(customersForUpdate.getName());
        customersRepository.save(exitingCustomers);
    }

    public void deleteCustomers(Customers customersForDeletion) {
        customersRepository.delete(customersForDeletion);
    }
}
