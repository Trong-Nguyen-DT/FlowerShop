package com.example.customer.controller.RESTfulAPI;

import com.example.customer.domain.Order;
import com.example.customer.responseBody.BodyOrder;
import com.example.customer.service.OrderService;
import com.example.customer.validator.CustomerValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/check-out")
public class CheckOutAPIController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerValidate customerValidate;

    @PostMapping()
    public ResponseEntity<Order> checkout(@RequestBody Order orderRequest) {
        String name = customerValidate.validateCustomer();
        Order response = orderService.returnCheckout(orderRequest, name);
        return ResponseEntity.ok(response);
    }
}
