package com.example.admin.Service;

import com.example.admin.Domain.Product;
import com.example.admin.Entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    ProductEntity addProduct(Product product);
}
