package com.example.admin.Controller.Admin;


import com.example.admin.Domain.Item;
import com.example.admin.Domain.Product;
import com.example.admin.Domain.ProductDetail;
import com.example.admin.Entity.ProductDetailEntity;
import com.example.admin.Entity.ProductEntity;
import com.example.admin.Repository.ProductDetailRepository;
import com.example.admin.Service.ItemService;
import com.example.admin.Service.ProductDetailService;
import com.example.admin.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/productDetail")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;
    
    @Autowired
    private ItemService itemService;

    @Autowired
    private ProductService productService;
    

    @GetMapping("/{productId}")
    public String showProductDetails(@PathVariable Long productId, Model model) {
        List<ProductDetail> productDetails = productDetailService.getProductDetailsByProductId(productId);
        List<Item> items = itemService.getAllItem();
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        model.addAttribute("items", items);
        model.addAttribute("productDetails", productDetails);
        return "Admin/ProductDetailAdmin"; // Trả về tên của view (thường là một template Thymeleaf hoặc JSP)
    }

}
