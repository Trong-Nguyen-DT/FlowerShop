package com.example.admin.Converter;

import com.example.admin.Domain.Product;
import com.example.admin.Entity.ProductEntity;

public class ProductConverter {
    public static Product toModel(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setOriginal_price(productEntity.getOriginal_price());
        product.setPrice(productEntity.getPrice());
        product.setDescription(productEntity.getDescription());
        product.setDetails(productEntity.getDetails());
        product.setDelivery(productEntity.getDelivery());
        product.setSub_info(productEntity.getSub_info());
        product.setOverall_rating(productEntity.getOverall_rating());
        product.setDiscount(productEntity.getDiscount());
        product.setImage1(productEntity.getImage1());
        product.setImage2(productEntity.getImage2());
        product.setImage3(productEntity.getImage3());
        product.setImage4(productEntity.getImage4());
        product.setImage5(productEntity.getImage5());
        product.setDeleted(productEntity.isDeleted());
//        product.setCategoryEntities(productEntity.getCategoryEntities().stream().map(CategoryConverter::toModel).toList());
//        product.setReviewEntities(productEntity.getReviewEntities());
//        product.setProductDetailEntities(productEntity.getProductDetailEntities());
        return product;
    }

    public static ProductEntity toEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setOriginal_price(product.getOriginal_price());
        entity.setPrice(product.getPrice());
        entity.setDescription(product.getDescription());
        entity.setDetails(product.getDetails());
        entity.setDelivery(product.getDelivery());
        entity.setSub_info(product.getSub_info());
        entity.setOverall_rating(product.getOverall_rating());
        entity.setDiscount(product.getDiscount());
        entity.setImage1(product.getImage1());
        entity.setImage2(product.getImage2());
        entity.setImage3(product.getImage3());
        entity.setImage4(product.getImage4());
        entity.setImage5(product.getImage5());
        entity.setDeleted(false);
        return entity;
    }
}
