package com.example.admin.Service;

import com.example.admin.Entity.ProductEntity;

import java.util.List;

public interface ProductDetailService {
    void addProductDetail(ProductEntity productEntity, List<Long> idList, int quantityFlower);
}
