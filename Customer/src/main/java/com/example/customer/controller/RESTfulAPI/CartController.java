package com.example.customer.controller.RESTfulAPI;


import com.example.customer.domain.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart")
public class CartController {

    @GetMapping("add/{id}")
    public String addItem(@RequestBody Customer customer) {



        return "";
    }
}
