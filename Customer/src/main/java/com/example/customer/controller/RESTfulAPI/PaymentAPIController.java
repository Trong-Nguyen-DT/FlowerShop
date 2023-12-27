package com.example.customer.controller.RESTfulAPI;

import com.example.customer.domain.Order;
import com.example.customer.responseBody.ResponsePayment;
import com.example.customer.service.Impl.FCMService;
import com.example.customer.service.NotificationService;
import com.example.customer.service.OrderHistoryService;
import com.example.customer.service.OrderService;
import com.example.customer.validator.CustomerValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private NotificationService notificationService;

    @PostMapping("app")
    public ResponseEntity<ResponsePayment> paymentApp(@RequestBody Order order, @RequestHeader HttpHeaders headers) {
        String name = customerValidate.validateCustomer();
        if (name == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Long orderId = orderService.createOrder(order, name);
        ResponsePayment payment = orderService.createResponsePayment(orderId);
        if (payment.getOrder().isPaymentOnline()) {
            payment.setUrlQR(orderService.createQrPayment(orderId));
        }
        Long id = orderHistoryService.addOrder(name, orderId);
        Long notifyId = notificationService.addNotifyOrder(name, id);
        notificationService.sendNotifyOrder(headers, notifyId, id);
        return ResponseEntity.ok(payment);
    }

    @PostMapping("web")
    public ResponseEntity<String> paymentWeb(@RequestBody Order order) {
        String name = customerValidate.validateCustomer();
        if (name == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Long orderId = orderService.createOrder(order, name);
        ResponsePayment payment = orderService.createResponsePayment(orderId);
        String url ="http://localhost/payment/success";
        if (payment.getOrder().isPaymentOnline()) {
            url = orderService.createUrlPayment(orderId);
        }
        orderHistoryService.addOrder(name, orderId);
        return ResponseEntity.ok(url);
    }

    @Transactional
    @GetMapping("success")
    public ResponseEntity<String> success(@RequestHeader HttpHeaders headers) {
        String name = customerValidate.validateCustomer();
        if (name == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Long notifyId = notificationService.addNotifyPayment(name, true);
        notificationService.sendNotifyPayment(headers, notifyId, true);
        if (headers.containsKey("Set-Cookie")) {
            System.out.println(headers.getFirst("Set-Cookie"));
        } else {
            System.out.println("không có");
        }
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
