package com.example.admin.Controller.Admin;

import com.example.admin.Domain.Product;
import com.example.admin.Domain.Item;
import com.example.admin.Entity.ProductEntity;
import com.example.admin.Service.CategoryService;
import com.example.admin.Service.ItemService;
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
    private ItemService itemService;

    @Autowired
    private ProductDetailService productDetailService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public String listProduct(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "Admin/ProductAdmin";
    }

    @GetMapping("add")
    public String showAddProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("items", itemService.getAllItem());
        model.addAttribute("categories", categoryService.getAllCategory());
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


    // Xem chi tiết sản phẩm
    @GetMapping("detail/{productId}")
    public String viewProduct(@PathVariable("productId") Long productId, Model model) {
        ProductEntity productEntity = productService.getProductById(productId);
        model.addAttribute("product", productEntity);
        // Các thông tin khác cần hiển thị
        return "Admin/ViewDetailProductAdmin";
    }

    // Chỉnh sửa sản phẩm
//    @GetMapping("edit/{productId}")
//    public String showEditProduct(@PathVariable("productId") Long productId, Model model) {
//        ProductEntity productEntity = productService.getProductById(productId);
//        model.addAttribute("product", productEntity);
//        // Các thông tin khác cần hiển thị
//        return "Admin/EditProductAdmin";
//    }
//    @PostMapping("edit/{productId}")
//    @Transactional
//    public String editProduct(@PathVariable("productId") Long productId, @ModelAttribute("product") Product updatedProduct) {
//        productService.updateProduct(productId, updatedProduct);
//        // Cập nhật thông tin sản phẩm
//        return "redirect:/admin/product";
//    }
    @GetMapping("edit/{productId}")
    public String showEditProduct(@PathVariable String productId, Model model) {
        Long editProductId = Long.parseLong(productId);
        model.addAttribute("product", productService.getProductById(editProductId));
        return "Admin/EditProductAdmin";
    }
    @PostMapping("edit")
    public String editProduct(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/admin/product";
    }
//    @PostMapping("edit/{productId}")
//    @Transactional
//    public String editProduct(@PathVariable("productId") Long productId, @ModelAttribute("product") Product updatedProduct) {
//        productService.updateProduct(productId, updatedProduct);
//        // Cập nhật thông tin sản phẩm
//        return "redirect:/admin/product";
//    }

    // Xóa sản phẩm
//    @GetMapping("delete/{productId}")
//    @Transactional
//    public String deleteProduct(@PathVariable("productId") Long productId) {
//        productService.deleteProduct(productId);
//        // Xóa sản phẩm
//        return "redirect:/admin/product";
//    }
    @GetMapping("delete/{productId}")
    public String deleteProduct(@PathVariable String productId) {
        Long deProductId = Long.parseLong(productId);
        productService.deleteProductById(deProductId);
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
