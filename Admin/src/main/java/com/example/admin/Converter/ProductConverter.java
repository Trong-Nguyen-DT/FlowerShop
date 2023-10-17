package com.example.admin.Converter;

import com.example.admin.Domain.Product;
import com.example.admin.Entity.ProductEntity;

public class ProductConverter {
    public static Product toModel(ProductEntity productEntity) {
        Product product = new Product();
        return product;
    }
}
