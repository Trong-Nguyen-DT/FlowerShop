package com.example.customer.controller.RESTfulAPI;


import com.example.customer.domain.Customer;
import com.example.customer.responseBody.LoginRequest;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login-customer")
public class LoginAPIController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public ResponseEntity<LoginRequest> login(@RequestParam String username, String password) {
        LoginRequest loginRequest = new LoginRequest();
        Customer customer = customerService.checkCustomer(username, password);
        if (customer != null) {
            loginRequest.setSuccess(true);
            loginRequest.setMessage("success");
            loginRequest.setResult(customer);
        } else {
            loginRequest.setSuccess(false);
            loginRequest.setMessage("Invalid username or password");
        }
        return ResponseEntity.ok().body(loginRequest);
    }
}
