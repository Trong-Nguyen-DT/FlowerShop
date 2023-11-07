package com.example.customer.controller.RESTfulAPI;


import com.example.customer.domain.Customer;
import com.example.customer.responseBody.CustomerResponse;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("my")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @GetMapping
    public ResponseEntity<CustomerResponse> viewInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        Customer customer = customerService.getCustomerByUsername(authentication.getName());
        CustomerResponse customerResponse = new CustomerResponse();
        if (customer != null) {
            customerResponse.setSuccess(true);
            customerResponse.setMessage("success");
            customerResponse.setResult(customer);
            return ResponseEntity.ok().body(customerResponse);
        }
        customerResponse.setSuccess(false);
        customerResponse.setMessage("Invalid username or password");
        return ResponseEntity.ok().body(customerResponse);
    }
}
