package com.example.admin.Controller.Admin;

import com.example.admin.Domain.Category;
import com.example.admin.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("admin")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("category")
    public String listCategory(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        return "Admin/CategoryAdmin";
    }

    @GetMapping("category/add")
    public String showAddCategory(Model model) {
        model.addAttribute("category", new Category());
        return "Admin/AddCategoryAdmin";
    }

    @PostMapping("category/add")
    public String addCategory(@ModelAttribute Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/category";
    }
}
