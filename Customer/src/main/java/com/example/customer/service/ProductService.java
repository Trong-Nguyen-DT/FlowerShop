package com.example.customer.service;

import com.example.customer.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    List<Product> getAllProductByCategory(Long categoryId);

    Product getProductById(Long id);
}
