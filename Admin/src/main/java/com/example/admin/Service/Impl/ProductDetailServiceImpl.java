package com.example.admin.Service.Impl;

import com.example.admin.Converter.CustomerConverter;
import com.example.admin.Converter.ProductDetailConverter;
import com.example.admin.Domain.ProductDetail;
import com.example.admin.Repository.ProductDetailRepository;
import com.example.admin.Repository.ProductRepository;
import com.example.admin.Service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDetail> getAllProductDetail() {
        return productDetailRepository.findAll().stream().map(ProductDetailConverter::toModel).toList();
    }
    public List<ProductDetail>  getProductDetailsByProductId(Long productId) {
        return productDetailRepository.findAllByProductEntity(productRepository.findById(productId).orElseThrow()).stream().map(ProductDetailConverter::toModel).toList();
    }

//    @Override
//    public ProductDetail getProductDetailById(Long productId) {
//        return null;
//    }
}
