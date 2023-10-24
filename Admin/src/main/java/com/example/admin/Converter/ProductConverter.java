package com.example.admin.Converter;

import com.example.admin.Domain.Product;
import com.example.admin.Entity.ProductEntity;

//public class ProductConverter {
//    public static Product toModel(ProductEntity productEntity) {
//        Product product = new Product();
//        return product;
//    }
//}

public class ProductConverter {
    public static Product toModel(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setDeleted(productEntity.isDeleted());
        return product;
    }

    public static ProductEntity toEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setDeleted(false);
        return productEntity;
    }
}
