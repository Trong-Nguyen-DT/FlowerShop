package com.example.customer.converter;

import com.example.customer.domain.Order;
import com.example.customer.domain.OrderHistory;
import com.example.customer.entity.OrderEntity;
import com.example.customer.entity.OrderHistoryEntity;

public class OrderConverter {
    public static Order toModel(OrderEntity orderEntity) {
        Order order = new Order();
        return order;
    }

    public static OrderHistory toModelOrderHistory(OrderHistoryEntity orderHistoryEntity) {
        OrderHistory orderHistory = new OrderHistory();
        return orderHistory;
    }
}
