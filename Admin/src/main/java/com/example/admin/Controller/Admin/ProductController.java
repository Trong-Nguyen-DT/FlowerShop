package com.example.admin.Controller.Admin;


import com.example.admin.Domain.Product;
import com.example.admin.Entity.ProductEntity;
import com.example.admin.Service.ProductDetailService;
import com.example.admin.Service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping()
    public String listProduct(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "Admin/ProductAdmin";
    }

    @GetMapping("add")
    public String showAddProduct(Model model) {
        model.addAttribute("product", new Product());
        return "Admin/AddProductAdmin";
    }

    @PostMapping("add")
    @Transactional
    public String addProduct(@ModelAttribute("product") Product product, @RequestParam("selectedItems") String selectedItems, @RequestParam("numberFlower") int numberFlower) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Long> idList = objectMapper.readValue(selectedItems, new TypeReference<List<Long>>() {});
            ProductEntity productEntity = productService.addProduct(product);
            productDetailService.addProductDetail(productEntity, idList, numberFlower);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/product";
    }




}
