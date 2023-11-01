package com.example.admin.Controller.Staff;

import com.example.admin.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("staff")
public class StaffProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("product")
    public String listCategory(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "Staff/Products";
    }

//    @GetMapping("product/add")
//    public String showAddCategory(Model model) {
//        model.addAttribute("product", new Category());
//        return "Staff/AddProductAdmin";
//    }

//    @PostMapping("product/add")
//    public String addCategory(@ModelAttribute Category category) {
//        categoryService.addCategory(category);
//        return "redirect:/admin/product";
//    }
}
