package com.example.customer.controller.RESTfulAPI;

import com.example.customer.domain.Customer;
import com.example.customer.responseBody.BodyResponse;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/forgot-password")
public class ForgotPasswordAPIController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public ResponseEntity<BodyResponse> checkUsername(@RequestBody Customer customer) {
        BodyResponse forgotPasswordRequest = new BodyResponse();
        if (customerService.checkUsername(customer.getUsername())) {
            forgotPasswordRequest.setSuccess(false);
            forgotPasswordRequest.setMessage("Account name hasn't been taken");
        } else {
            customerService.changePassword(customer);
            forgotPasswordRequest.setSuccess(true);
            forgotPasswordRequest.setMessage("success");
        }
        return ResponseEntity.ok(forgotPasswordRequest);
    }
}
