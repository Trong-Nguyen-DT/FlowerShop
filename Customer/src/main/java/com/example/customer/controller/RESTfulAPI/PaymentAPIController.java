package com.example.customer.controller.RESTfulAPI;

import com.example.customer.domain.Order;
import com.example.customer.responseBody.ResponsePayment;
import com.example.customer.service.Impl.FCMService;
import com.example.customer.service.OrderHistoryService;
import com.example.customer.service.OrderService;
import com.example.customer.validator.CustomerValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.WebSocketSession;

@RestController
@RequestMapping("api/payment")
public class PaymentAPIController {

    @Autowired
    private CustomerValidate customerValidate;

    @Autowired
    private OrderService orderService;

    @Autowired
    private FCMService fcmService;

    @Autowired
    private OrderHistoryService orderHistoryService;

    @PostMapping("app")
    public ResponseEntity<ResponsePayment> paymentApp(@RequestBody Order order) {
        String name = customerValidate.validateCustomer();
        if (name == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Long orderId = orderService.createOrder(order, name);
        ResponsePayment payment = orderService.createResponsePayment(orderId);
        if (payment.getOrder().isPaymentOnline()) {
            payment.setUrlQR(orderService.createQrPayment(orderId));
        }
        return ResponseEntity.ok(payment);
    }

    @Transactional
    @GetMapping("{orderId}/success")
    public ResponseEntity<String> success(@PathVariable Long orderId) {
        String name = customerValidate.validateCustomer();
        if (name == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        orderHistoryService.addOrder(name, orderId);
        String response = fcmService.pushNotification(name, "payment_success");
        return ResponseEntity.ok(response);
    }

    @Transactional
    @GetMapping("failed")
    public ResponseEntity<String> failed() {
        String name = customerValidate.validateCustomer();
        if (name == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String response = fcmService.pushNotification(name, "payment_failed");
        return ResponseEntity.ok(response);
    }

}
