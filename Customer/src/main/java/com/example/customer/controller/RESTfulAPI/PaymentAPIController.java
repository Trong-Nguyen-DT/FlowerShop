package com.example.customer.controller.RESTfulAPI;

import com.example.customer.domain.Order;
import com.example.customer.responseBody.BodyOrder;
import com.example.customer.Payment.DataResponse;
import com.example.customer.responseBody.ResponsePayment;
import com.example.customer.service.OrderService;
import com.example.customer.validator.CustomerValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/payment")
public class PaymentAPIController {

    @Autowired
    private CustomerValidate customerValidate;

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<ResponsePayment> payment(@RequestBody Order order) {
        String name = customerValidate.validateCustomer();
        if (name == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Long orderId = orderService.createOrder(order, name);
        ResponsePayment response = new ResponsePayment();
        response.setSuccess(true);
        response.setMessage("success");
        if (order.isPaymentOnline()) {
            DataResponse data = orderService.createQrPayment(orderId);
            response.setData(data);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(response);
    }
}
