package com.example.customer.controller.RESTfulAPI;

import com.example.customer.domain.Product;
import com.example.customer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductAPIController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok().body(products);
    }
    @GetMapping("flash-sale")
    public ResponseEntity<List<Product>> getAllProductFlashSale() {
        productService.updateExpiredFlashSale();
        return ResponseEntity.ok(productService.getAllProductSale());
    }
    @GetMapping("best-seller")
    public ResponseEntity<List<Product>> getAllProductBestSeller() {
        List<Product> products = productService.getProductBestSeller();
        return ResponseEntity.ok(products);
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }
    @GetMapping("search-category/{id}")
    public ResponseEntity<List<Product>> getAllProductByCategory(@PathVariable Long id) {
//        Long categoryId = (long) id;
        List<Product> products = productService.getAllProductByCategory(id);
        return ResponseEntity.ok().body(products);
    }


}
