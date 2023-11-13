package com.example.customer.controller.RESTfulAPI;


import com.example.customer.domain.Customer;
import com.example.customer.responseBody.CustomerResponse;
import com.example.customer.service.CustomerService;
import com.example.customer.validator.CustomerValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customer")
public class CustomerAPIController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerValidate customerValidate;

    @GetMapping
    public ResponseEntity<CustomerResponse> viewInfo() {
        String name = customerValidate.validateCustomer();
        if (name != null) {
            Customer customer = customerService.getCustomerByUsername(name);
            CustomerResponse customerResponse = new CustomerResponse();
            if (customer != null) {
                customerResponse.setSuccess(true);
                customerResponse.setMessage("success");
                customerResponse.setResult(customer);
            } else {
                customerResponse.setSuccess(false);
                customerResponse.setMessage("Invalid username or password");
            }
            return ResponseEntity.ok().body(customerResponse);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("update")
    public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody Customer newCustomer) {
        CustomerResponse customerResponse = new CustomerResponse();
        String name = customerValidate.validateCustomer();
        if (name != null ) {
            System.out.println("Phone: " + newCustomer.getPhone());
            System.out.println("name: " + newCustomer.getFullName());
            System.out.println("email: " + newCustomer.getEmail());
            System.out.println("sex: " + newCustomer.isSex());
            System.out.println("birth: " + newCustomer.getBirth());
            Customer customer = customerService.updateCustomer(name, newCustomer);
            customerResponse.setSuccess(true);
            customerResponse.setMessage("success");
            customerResponse.setResult(customer);
            return ResponseEntity.ok(customerResponse);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
