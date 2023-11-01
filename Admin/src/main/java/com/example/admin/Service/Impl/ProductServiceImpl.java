package com.example.admin.Service.Impl;

import com.example.admin.Converter.ProductConverter;
import com.example.admin.Domain.Product;
import com.example.admin.Repository.ProductRepository;
import com.example.admin.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll().stream().map(ProductConverter::toModel).toList();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(ProductConverter.toEntity(product));
    }
}