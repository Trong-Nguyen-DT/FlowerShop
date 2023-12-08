package com.example.admin.Controller.Admin;

import com.example.admin.Domain.Category;
import com.example.admin.Domain.Product;
import com.example.admin.Domain.ProductDTO;
import com.example.admin.Entity.ProductEntity;
import com.example.admin.Service.CategoryService;
import com.example.admin.Service.ItemService;
import com.example.admin.Service.ProductDetailService;
import com.example.admin.Service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.List;


@Controller
@RequestMapping("admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDetailService productDetailService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public String listProduct(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "Admin/ProductAdmin";
    }
    @GetMapping("add")
    public String showProduct(Model model){
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("product", new Product()); // Thay vì new ProductController()
        model.addAttribute("categories", categories);

        return "Admin/AddProductAdmin";
    }
//    @PostMapping("add")
//    public String addProduct(@ModelAttribute Product product){
//        productService.addProduct(product);
//        return "redirect:/admin/product";
//    }

    @Transactional
    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductDTO productDto) {
        System.out.println("vào được");
        // Example: Print received data to the console
        System.out.println("Name: " + productDto.getName());
        System.out.println("Original Price: " + productDto.getOriginalPrice());
        System.out.println("Category IDs: " + productDto.getCategoryIds());

        // Add your business logic to save the product and its associated categories
        ProductEntity productEntity = productService.createProduct(productDto);
        productService.setCategories(productEntity, productDto);
        // Redirect to a success page or return a response accordingly
        return "redirect:/success-page";
    }



    @GetMapping("edit/{id}")
    public String showEditProduct(@PathVariable String id, Model model) {
        List<Category> categories = categoryService.getAllCategory();
        Long productId = Long.parseLong(id);
        model.addAttribute("product", productService.getProductById(productId));
        model.addAttribute("categories", categories);
        return "Admin/EditProductAdmin";
    }

    @PostMapping("edit")
    public String editProduct(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/admin/product";
    }
    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        Long productId = Long.parseLong(id);
        productService.deleteProductById(productId);
        return "redirect:/admin/product";
    }
    @GetMapping("restore")
    public String listProductRestore(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "Admin/RestoreProductAdmin";
    }
    @GetMapping("restore/{id}")
    public String restoreProduct(@PathVariable String id) {
        Long productId = Long.parseLong(id);
        productService.restoreProductById(productId);
        return "redirect:/admin/product/restore";
    }
}
