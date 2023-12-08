package com.example.admin.Service;

import com.example.admin.Domain.Category;
import com.example.admin.Domain.Product;
import com.example.admin.Domain.ProductDTO;
import com.example.admin.Entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    void addProduct(Product product);

    Product getProductById(Long productId);

    void updateProduct(Product product);

    void deleteProductById(Long productId);

    void restoreProductById(Long productId);

    ProductEntity createProduct(ProductDTO productDto);

    void setCategories(ProductEntity productEntity, ProductDTO productDto);
}
