package com.example.admin.Service;

import com.example.admin.Domain.ProductDetail;
import com.example.admin.Entity.ProductEntity;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetail> getAllProductDetail();
    List<ProductDetail> getProductDetailsByProductId(Long productId);
}
