package com.example.admin.Converter;

import com.example.admin.Domain.ProductDetail;
import com.example.admin.Entity.ItemEntity;
import com.example.admin.Entity.ProductDetailEntity;
import com.example.admin.Entity.ProductEntity;

public class ProductDetailConverter {
    public static ProductDetail toModel(ProductDetailEntity productDetailEntity) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setId(productDetailEntity.getId());
        productDetail.setQuantity(productDetailEntity.getQuantity());

        // Chuyển đổi thông tin từ ProductEntity (nếu có)
        ProductEntity productEntity = productDetailEntity.getProductEntity();
        if (productEntity != null) {
            productDetail.setProductId(productEntity.getId());
            // Thêm các trường khác nếu cần
        }

        // Chuyển đổi thông tin từ ItemEntity (nếu có)
        ItemEntity itemEntity = productDetailEntity.getItemsEntity();
        if (itemEntity != null) {
            productDetail.setItemId(itemEntity.getId());
            // Thêm các trường khác nếu cần
        }

        return productDetail;
    }

    public static ProductDetailEntity toEntity(ProductDetail productDetail) {
        ProductDetailEntity productDetailEntity = new ProductDetailEntity();
        productDetailEntity.setId(productDetail.getId());
        productDetailEntity.setQuantity(productDetail.getQuantity());

        // Chuyển đổi thông tin từ ProductDetail (nếu có)
        if (productDetail.getProductId() != null) {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setId(productDetail.getProductId());
            // Thêm các trường khác nếu cần
            productDetailEntity.setProductEntity(productEntity);
        }

        // Chuyển đổi thông tin từ ProductDetail (nếu có)
        if (productDetail.getItemId() != null) {
            ItemEntity itemEntity = new ItemEntity();
            itemEntity.setId(productDetail.getItemId());
            // Thêm các trường khác nếu cần
            productDetailEntity.setItemsEntity(itemEntity);
        }

        return productDetailEntity;
    }
}
