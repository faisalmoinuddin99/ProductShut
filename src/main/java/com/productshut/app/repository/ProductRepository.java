package com.productshut.app.repository;

import com.productshut.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByProductName(String name);
}
