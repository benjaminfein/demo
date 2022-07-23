package com.example.demo.products.repository;

import com.example.demo.products.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
    Optional<Products> findById(Integer id);
}
