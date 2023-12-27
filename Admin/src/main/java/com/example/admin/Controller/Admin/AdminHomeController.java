package com.example.admin.Controller.Admin;


import com.example.admin.Service.CustomerService;
import com.example.admin.Service.OrderDetailService;
import com.example.admin.Service.OrderService;
import com.example.admin.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Controller
@RequestMapping("admin")
public class AdminHomeController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private ProductService productService;


    @GetMapping
    public String adminHome(Model model) {
        model.addAttribute("quantityCustomer", customerService.getAllCustomer().size());
        model.addAttribute("quantityOrder", orderService.getAllOrderHistory().size());
        double total = orderService.getAllTotalByTime(LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), 1, 0, 0), LocalDateTime.now());
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedTotal = decimalFormat.format(total);
        model.addAttribute("totalAmount", formattedTotal);
        model.addAttribute("topProduct", orderDetailService.getTop4Product());
        model.addAttribute("products", productService.getAllProduct());


        return "Admin/AdminHome";
    }
//    @GetMapping
//    public String adminHome() {
//        return "Admin/AdminHome";
//    }
}
