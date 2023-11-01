package com.example.customer.converter;

import com.example.customer.domain.Order;
import com.example.customer.entity.OrderEntity;

public class OrderConverter {
    public static Order toModel(OrderEntity orderEntity) {
        Order order = new Order();
        return order;
    }
}
