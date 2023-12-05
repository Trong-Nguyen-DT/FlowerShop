package com.example.admin.Converter;

import com.example.admin.Domain.OrderDetailHistory;
import com.example.admin.Entity.OrderDetailHistoryEntity;

public class OrderDetailHistoryConverter {
    public static OrderDetailHistory toModel (OrderDetailHistoryEntity orderDetailHistoryEntity){
        OrderDetailHistory orderDetailHistory = new OrderDetailHistory();
        orderDetailHistory.setId(orderDetailHistoryEntity.getId());
        orderDetailHistory.setOrderHistory(OrderConverter.toModelHistory(orderDetailHistoryEntity.getOrderHistoryEntity()));
        orderDetailHistory.setNameProduct(orderDetailHistoryEntity.getNameProduct());
        orderDetailHistory.setQuantity(orderDetailHistoryEntity.getQuantity());
        orderDetailHistory.setProductId(orderDetailHistoryEntity.getProductId());
        orderDetailHistory.setPriceProduct(orderDetailHistoryEntity.getPriceProduct());
        return orderDetailHistory;
    }
}
