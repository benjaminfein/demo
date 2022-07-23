package com.example.demo.products.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private String company;
    @Column(insertable = false, updatable = false)
    private int productCount;
    @Column(insertable = false, updatable = false)
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return productCount == products.productCount && Double.compare(products.price, price) == 0
                && Objects.equals(productName, products.productName) && Objects.equals(company, products.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, company, productCount, price);
    }
}
