package com.example.customer.controller.RESTfulAPI;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/verify")
public class VerifyOPTController {

    @PostMapping("otp")
    public String verifyOTP() {


        return "";
    }
}
