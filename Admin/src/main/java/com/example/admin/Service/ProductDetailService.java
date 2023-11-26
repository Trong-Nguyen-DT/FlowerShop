package com.example.admin.Service;

import com.example.admin.Domain.ProductDetail;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetail> getAllProductDetail();

//    ProductDetail getProductDetailById(Long id);

    List<ProductDetail> getProductDetailsByProductId(Long productId);

//    void detailProduct(Item item);
//    void addProductDetail(ProductEntity productEntity, List<Long> idList, int quantityFlower);
}
