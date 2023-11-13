package com.example.customer.service.Impl;

import com.example.customer.converter.ProductConverter;
import com.example.customer.domain.Product;
import com.example.customer.entity.CategoryEntity;
import com.example.customer.repository.CategoryRepository;
import com.example.customer.repository.ProductRepository;
import com.example.customer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll().stream().map(ProductConverter::toModel).toList();
    }

    @Override
    public List<Product> getAllProductByCategory(Long categoryId) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId).orElseThrow();
        return productRepository.findAllByCategoryEntities(categoryEntity).stream().map(ProductConverter::toModel).toList();
    }

    @Override
    public Product getProductById(Long id) {
        return ProductConverter.toModel(productRepository.findById(id).orElseThrow());
    }
}
