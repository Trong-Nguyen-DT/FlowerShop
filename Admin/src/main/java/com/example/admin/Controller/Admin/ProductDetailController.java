package com.example.admin.Controller.Admin;

import com.example.admin.Domain.Item;
import com.example.admin.Domain.Product;
import com.example.admin.Entity.ItemEntity;
import com.example.admin.Entity.ProductEntity;
import com.example.admin.Service.ItemService;
import com.example.admin.Service.ProductDetailService;
import com.example.admin.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin/productDetail")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;

    @Autowired
    private  ProductService productService;

    @Autowired
    private ItemService itemService;

//    @GetMapping()
//    public String listProductDetail(Model model) {
//        model.addAttribute("productDetails", productDetailService.getAllProductDetail());
//        model.addAttribute("items", itemService.getAllItem());
//        model.addAttribute("products", productService.getAllProduct());
//        return "Admin/ProductDetailAdmin";
//    }

//    @GetMapping("productDetail/{productId}")
//    public String showProductDetail(@PathVariable Long productId, Model model) {
//        // Lấy thông tin của product dựa trên productId
//        ProductEntity productEntity = productService.getProductById(productId);
//
//        // Lấy danh sách items của product
//        List<ItemEntity> items = productEntity.getItems();
//
//        // Đưa thông tin vào model để hiển thị trên trang
//        model.addAttribute("product", productEntity);
//        model.addAttribute("items", items);
//
//        return "Admin/ProductDetailAdmin";
//    }


//    @GetMapping("productDetail/{id}")
//    public String showProductDetail(@PathVariable String id, Model model) {
//        Long productDetailId = Long.parseLong(id);
//        model.addAttribute("items", itemService.getItemById(productDetailId));
//        return "Admin/ProductDetailAdmin";
//    }
//    @PostMapping("productDetail")
//    public String detailProduct(@ModelAttribute Item item) {
//        itemService.detailProduct(item);
//        return "redirect:/admin/productDetail";
//    }
}
