package com.example.admin.Controller.Staff;

import com.example.admin.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("staff")
public class StaffHomeController {
    @Autowired
    private ProductService productService;
    @GetMapping()
    public String showStaffHome(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "Staff/Products";
    }
}
