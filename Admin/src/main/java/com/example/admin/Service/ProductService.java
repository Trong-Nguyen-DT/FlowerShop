package com.example.admin.Service;

import com.example.admin.Domain.Category;
import com.example.admin.Domain.Product;
import com.example.admin.Entity.ProductDetailEntity;
import com.example.admin.Entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    ProductEntity addProduct(Product product);

    ProductEntity getProductById(Long productId);

//    void updateProduct(Long productId, Product updatedProduct);
    void updateProduct(Product product);

//    void deleteProduct(Long productId);

    void deleteProductById(Long productId);

    void restoreProductById(Long productId);

}
