package com.example.admin.Service;

import com.example.admin.Domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    void addProduct(Product product);
}
