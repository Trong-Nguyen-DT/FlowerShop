package com.example.customer.service;

import com.example.customer.responseBody.DataResponsePayment;
import com.example.customer.responseBody.BodyOrder;

public interface OrderService {
    Long createOrder(BodyOrder order, String name);

    DataResponsePayment createQrPayment(Long orderId);

    BodyOrder returnCheckout(BodyOrder orderRequest, String name);
}
