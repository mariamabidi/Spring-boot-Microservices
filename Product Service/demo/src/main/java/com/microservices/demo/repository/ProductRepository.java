package com.microservices.demo.repository;

import com.microservices.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.cache.annotation.Cacheable;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Cacheable(value = "products")  // Cache results for faster queries
    List<Product> findAll();
}
