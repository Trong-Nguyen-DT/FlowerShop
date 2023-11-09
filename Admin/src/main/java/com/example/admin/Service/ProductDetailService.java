package com.example.admin.Service;

import com.example.admin.Domain.Customer;
import com.example.admin.Domain.Item;
import com.example.admin.Domain.ProductDetail;
import com.example.admin.Entity.ProductDetailEntity;
import com.example.admin.Entity.ProductEntity;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetail> getAllProductDetail();

    ProductDetailEntity getProductDetailById(Long productId);

    List<ProductDetail> getProductDetailsByProductId(Long productId);

//    void detailProduct(Item item);
//    void addProductDetail(ProductEntity productEntity, List<Long> idList, int quantityFlower);
}
