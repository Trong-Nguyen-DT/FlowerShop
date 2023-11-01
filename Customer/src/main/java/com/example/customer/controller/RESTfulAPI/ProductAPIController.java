package com.example.customer.controller.RESTfulAPI;

import com.example.customer.domain.Product;
import com.example.customer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductAPIController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("search-category")
    public ResponseEntity<List<Product>> getAllProductByCategory(@RequestBody int id) {
        Long categoryId = (long) id;
        List<Product> products = productService.getAllProductByCategory(categoryId);
        return ResponseEntity.ok().body(products);
    }
}
