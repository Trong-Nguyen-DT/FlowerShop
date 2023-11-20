package com.example.customer.converter;

import com.example.customer.domain.OrderDetail;
import com.example.customer.domain.OrderDetailHistory;
import com.example.customer.entity.OrderDetailEntity;
import com.example.customer.entity.OrderDetailHistoryEntity;

public class OrderDetailConverter {
    public static OrderDetail toModel(OrderDetailEntity orderDetailEntity) {
        OrderDetail orderDetail = new OrderDetail();

        return orderDetail;
    }

    public static OrderDetailHistory toModel(OrderDetailHistoryEntity orderDetailHistoryEntity) {
        OrderDetailHistory orderDetailHistory = new OrderDetailHistory();

        return orderDetailHistory;
    }

//    public static OrderDetailHistory toOrderDetailHistory(OrderDetailHistoryEntity entity) {
//        OrderDetailHistory orderDetailHistory = new OrderDetailHistory();
//        orderDetailHistory.setId(entity.getId());
//        orderDetailHistory.setOrderHistory_id(orderDetailHistory.getOrderHistory_id());
//        orderDetailHistory.setProductId(entity.getProductId());
//        orderDetailHistory.setNameProduct(entity.getNameProduct());
//        orderDetailHistory.setPriceProduct(entity.getPriceProduct());
//        orderDetailHistory.setQuantity(entity.getQuantity());
//        return orderDetailHistory;
//    }

//    public static OrderDetailHistory OrderDetailEntitytoOrderDetailHistory(OrderDetailEntity entity) {
//        OrderDetailHistory orderDetailHistory = new OrderDetailHistory();
//        orderDetailHistory.setId(entity.getId());
//        orderDetailHistory.setOrderHistory_id(orderDetailHistory.getOrderHistory_id());
//        orderDetailHistory.setProductId(entity.getProductEntity().getId());
//        orderDetailHistory.setNameProduct(entity.getProductEntity().getName());
//        orderDetailHistory.setPriceProduct(entity.getProductEntity().getPrice());
//        orderDetailHistory.setQuantity(entity.getQuantity());
//        return orderDetailHistory;
//    }
}
