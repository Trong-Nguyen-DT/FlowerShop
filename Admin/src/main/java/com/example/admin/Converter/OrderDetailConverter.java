package com.example.admin.Converter;

import com.example.admin.Domain.OrderDetail;
import com.example.admin.Domain.OrderDetailHistory;
import com.example.admin.Entity.OrderDetailEntity;
import com.example.admin.Entity.OrderDetailHistoryEntity;

public class OrderDetailConverter {
    public static OrderDetail toModel (OrderDetailEntity orderDetailEntity){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(orderDetailEntity.getId());
        orderDetail.setOrderId(orderDetailEntity.getOrderEntity().getId());
        orderDetail.setProductId(orderDetailEntity.getProductEntity().getId());
        orderDetail.setQuantity(orderDetailEntity.getQuantity());
        return orderDetail;
    }

    public static OrderDetailHistory toOrderDetailHistory(OrderDetailHistoryEntity entity) {
        OrderDetailHistory orderDetailHistory = new OrderDetailHistory();
        orderDetailHistory.setId(entity.getId());
        orderDetailHistory.setProductId(entity.getProductId());
        orderDetailHistory.setNameProduct(entity.getNameProduct());
        orderDetailHistory.setPriceProduct(entity.getPriceProduct());
        orderDetailHistory.setQuantity(entity.getQuantity());
        return orderDetailHistory;
    }

    public static OrderDetailHistory OrderDetailEntitytoOrderDetailHistory(OrderDetailEntity entity) {
        OrderDetailHistory orderDetailHistory = new OrderDetailHistory();
        orderDetailHistory.setId(entity.getId());
        orderDetailHistory.setProductId(entity.getProductEntity().getId());
        orderDetailHistory.setNameProduct(entity.getProductEntity().getName());
        orderDetailHistory.setPriceProduct(entity.getProductEntity().getPrice());
        orderDetailHistory.setQuantity(entity.getQuantity());
        return orderDetailHistory;
    }
}
