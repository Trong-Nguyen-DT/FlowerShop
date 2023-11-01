package com.example.admin.Controller.Staff;

import com.example.admin.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("staff")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("customer")
    public String listCustomer(Model model) {
        model.addAttribute("customers", customerService.getAllCustomer());
        return "Staff/Customers";
    }

    @GetMapping("customer/{id}")
    public String customerDetail(@PathVariable String id, Model model) {
        Long customerId = Long.parseLong(id);
        return "Staff/CustomerDetail";

    }
}
