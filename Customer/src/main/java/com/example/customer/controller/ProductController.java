package com.example.customer.controller;

import com.example.customer.domain.Product;
import com.example.customer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("product")
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/detail")
    public String productDetail(@RequestParam Long id, Model model) {
        Product product = productService.getProductById(id);

        // Đặt thông tin sản phẩm vào model
        model.addAttribute("idProduct", product.getId());
        model.addAttribute("productName", product.getName());
        model.addAttribute("productPrice", product.getPrice());

        // Trả về tên của view (trang chi tiết sản phẩm)
        return "product_Detail";
    }


}
