package com.example.customer.service;

import com.example.customer.Payment.DataResponse;
import com.example.customer.domain.Order;
import com.example.customer.responseBody.BodyOrder;

public interface OrderService {
    Long createOrder(Order order, String name);

    DataResponse createQrPayment(Long orderId);

    Order returnCheckout(Order orderRequest, String name);
}
