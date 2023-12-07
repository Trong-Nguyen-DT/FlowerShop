package com.example.customer.converter;

import com.example.customer.domain.ProductDetail;
import com.example.customer.entity.ProductDetailEntity;

public class ProductDetailConverter {
    public static ProductDetail toModel(ProductDetailEntity entity) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setId(entity.getId());
        productDetail.setQuantity(entity.getQuantity());
        productDetail.setItemId(entity.getItemsEntity().getId());
        productDetail.setProductId(entity.getProductEntity().getId());
        return productDetail;
    }
}
