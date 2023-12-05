package com.example.customer.converter;

import com.example.customer.domain.Order;
import com.example.customer.domain.OrderDetail;
import com.example.customer.domain.OrderHistory;
import com.example.customer.entity.CartItemEntity;
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

    public static OrderDetail cartItemToOrderDetail(CartItemEntity entity) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setName(entity.getProductEntity().getName());
        orderDetail.setPrice(entity.getProductEntity().getPrice());
        orderDetail.setQuantity(entity.getQuantity());
        return orderDetail;
    }
}
