package com.example.admin.Converter;

import com.example.admin.Domain.ProductDetail;
import com.example.admin.Entity.ProductDetailEntity;
import com.example.admin.Entity.ProductEntity;
import com.example.admin.Entity.ItemEntity;

public class ProductDetailConverter {
    public static ProductDetail toModel(ProductDetailEntity productDetailEntity) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setId(productDetailEntity.getId());
        productDetail.setQuantity(productDetailEntity.getQuantity());

        ProductEntity productEntity = productDetailEntity.getProduct();
        if (productEntity != null) {
            productDetail.setProductId(productEntity.getId());
        }

        // Lấy thông tin từ bảng items
        ItemEntity itemEntity = productDetailEntity.getItems();
        if (itemEntity != null) {
            productDetail.setItemId(itemEntity.getId());
        }
        return productDetail;
    }
}
