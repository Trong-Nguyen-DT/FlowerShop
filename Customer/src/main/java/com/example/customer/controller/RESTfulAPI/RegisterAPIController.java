package com.example.customer.controller.RESTfulAPI;

import com.example.customer.domain.Customer;
import com.example.customer.responseBody.RegisterRequest;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")
public class RegisterAPIController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<RegisterRequest> register(@RequestBody Customer customer) {
        RegisterRequest registerRequest = new RegisterRequest();
        if (customerService.checkUsername(customer.getUsername())) {
            customerService.createCustomer(customer);
            registerRequest.setSuccess(true);
            registerRequest.setMessage("success");
        } else {
            registerRequest.setSuccess(false);
            registerRequest.setMessage("Account name has been taken");
        }
        return ResponseEntity.ok().body(registerRequest);
    }
}
