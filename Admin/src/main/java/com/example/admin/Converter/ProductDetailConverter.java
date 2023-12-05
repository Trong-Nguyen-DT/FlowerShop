package com.example.admin.Converter;

import com.example.admin.Domain.ProductDetail;
import com.example.admin.Entity.ItemEntity;
import com.example.admin.Entity.ProductDetailEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDetailConverter {
    public static ProductDetail toModel(ProductDetailEntity productDetailEntity) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setId(productDetailEntity.getId());
        productDetail.setQuantity(productDetailEntity.getQuantity());

        productDetail.setProduct(ProductConverter.toModel(productDetailEntity.getProductEntity()));
        productDetail.setItem(ItemConverter.toModel(productDetailEntity.getItemsEntity()));

        return productDetail;
    }

    public static ProductDetailEntity toEntity(ProductDetail productDetail) {
        ProductDetailEntity productDetailEntity = new ProductDetailEntity();
        productDetailEntity.setId(productDetail.getId());
        productDetailEntity.setQuantity(productDetail.getQuantity());

        productDetailEntity.setProductEntity(ProductConverter.toEntity(productDetail.getProduct()));
        productDetailEntity.setItemsEntity(ItemConverter.toEntity(productDetail.getItem()));

        return productDetailEntity;
    }
    public static List<ProductDetailEntity> toEntityList(List<ProductDetail> productDetails) {
        return productDetails.stream()
                .map(ProductDetailConverter::toEntity)
                .collect(Collectors.toList());
    }
}
