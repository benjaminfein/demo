package com.example.demo.products.service;

import com.example.demo.products.model.Products;
import com.example.demo.products.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    public ProductsRepository productsRepository;

    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    public void createProducts(Products products) {
        productsRepository.save(products);
    }

    public Products findById(Integer id) {
        return productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such order by id: " + id));
    }

    public void updateProducts(Products exitingProducts, Products productsForUpdate) {
        exitingProducts.setId(productsForUpdate.getId());
        exitingProducts.setProductName(productsForUpdate.getProductName());
        exitingProducts.setCompany(productsForUpdate.getCompany());
        exitingProducts.setProductCount(productsForUpdate.getProductCount());
        exitingProducts.setPrice(productsForUpdate.getPrice());
        productsRepository.save(exitingProducts);
    }

    public void deleteProducts(Products productsForDeletion) {
        productsRepository.delete(productsForDeletion);
    }
}
