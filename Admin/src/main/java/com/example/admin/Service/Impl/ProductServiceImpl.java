package com.example.admin.Service.Impl;

import com.example.admin.Converter.ProductConverter;
import com.example.admin.Domain.Product;
import com.example.admin.Entity.ProductEntity;
import com.example.admin.Repository.ProductRepository;
import com.example.admin.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll().stream().map(ProductConverter::toModel).toList();
    }

//    @Override
//    public ProductEntity addProduct(Product product) {
//        ProductEntity productEntity = ProductConverter.toEntity(product);
//        return productRepository.save(productEntity);
//    }
    @Override
    public ProductEntity getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

//    @Override
//    public void updateProduct(Product product) {
//        ProductEntity existingProduct = productRepository.findById(product.getId()).orElse(null);
//
//        if (existingProduct != null) {
//            // Update fields of existingProduct with values from updatedProduct
//            existingProduct.setName(product.getName());
//            existingProduct.setImage1(product.getImage1());
//            existingProduct.setImage2(product.getImage2());
//            existingProduct.setImage3(product.getImage3());
//            existingProduct.setImage4(product.getImage4());
//            existingProduct.setImage5(product.getImage5());
//            existingProduct.setOriginal_price(product.getOriginal_price());
//            existingProduct.setDiscount(product.getDiscount());
//            existingProduct.setDetails(product.getDetails());
//
//            existingProduct.updateFinalPrice();
//            // Add other fields as needed
//
//            productRepository.save(existingProduct);
//        }
//    }
    @Override
    public void deleteProductById(Long productId) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow();
        productEntity.setDeleted(true);
        productRepository.save(productEntity);
    }
    @Override
    public void restoreProductById(Long productId){
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow();
        productEntity.setDeleted(false);
        productRepository.save(productEntity);
    }
}
