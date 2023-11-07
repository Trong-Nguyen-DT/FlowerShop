package com.example.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParsePosition;

@Controller
public class homeController {
    @GetMapping("home")
    public  String home()
    {
        return "home";
    }
}
