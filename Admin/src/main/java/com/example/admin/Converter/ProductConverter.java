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
        product.setDelivery(productEntity.getDelivery());
        product.setDescription(productEntity.getDescription());
        product.setDetails(productEntity.getDetails());
        product.setDiscount(productEntity.getDiscount());
        product.setImage1(productEntity.getImage1());
        product.setImage2(productEntity.getImage2());
        product.setImage3(productEntity.getImage3());
        product.setImage4(productEntity.getImage4());
        product.setImage5(productEntity.getImage5());
        product.setOriginal_price(productEntity.getOriginal_price());
        product.setOverall_rating(productEntity.getOverall_rating());
        product.setPrice(productEntity.getPrice());
        product.setSub_info(productEntity.getSub_info());
        product.setDeleted(productEntity.isDeleted());
        return product;
    }

    public static ProductEntity toEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setDelivery(product.getDelivery());
        productEntity.setDescription(product.getDescription());
        productEntity.setDetails(product.getDetails());
        productEntity.setDiscount(product.getDiscount());
        productEntity.setImage1(product.getImage1());
        productEntity.setOriginal_price(product.getOriginal_price());
        productEntity.setOverall_rating(product.getOverall_rating());
        productEntity.setPrice(product.getPrice());
        productEntity.setSub_info(product.getSub_info());
        productEntity.setDeleted(false);
        return productEntity;
    }
}
