package com.example.customer.controller.RESTfulAPI;


import com.example.customer.domain.Customer;
import com.example.customer.responseBody.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login-customer")
public class LoginAPIController {



    @PostMapping()
    public ResponseEntity<LoginRequest> login(@RequestBody String username, @RequestBody String password) {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setSuccess(true);
        loginRequest.setMessage("success");
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setEmail("dangthitrucny@gmail.com");
        customer.setPhone("123");
        customer.setAddress("đn");
        customer.setUsername(username);
        customer.setPassword(password);
        loginRequest.setResult(customer);
        return ResponseEntity.ok().body(loginRequest);
    }
}
