package com.example.admin.Converter;

import com.example.admin.Domain.OrderHistory;
import com.example.admin.Entity.OrderHistoryEntity;

public class OrderHistoryConverter {
    public static OrderHistory toModel(OrderHistoryEntity orderHistoryEntity) {
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setId(orderHistoryEntity.getId());
        orderHistory.setDiscount(orderHistoryEntity.getDiscount());
        orderHistory.setOrderDateTime(orderHistoryEntity.getOrderDateTime());
        orderHistory.setTotalPrice(orderHistoryEntity.getTotalPrice());
        orderHistory.setAmount(orderHistoryEntity.getAmount());
        orderHistory.setRole(orderHistoryEntity.getRole());
        orderHistory.setCustomerId(orderHistoryEntity.getCustomerId());
        orderHistory.setEmailCustomer(orderHistoryEntity.getEmailCustomer());
        orderHistory.setPhoneCustomer(orderHistoryEntity.getPhoneCustomer());
        orderHistory.setFullNameStaff(orderHistoryEntity.getFullNameStaff());
        orderHistory.setFullNameCustomer(orderHistoryEntity.getFullNameCustomer());
        orderHistory.setUserId(orderHistoryEntity.getUserId());

        return orderHistory;
    }
    public static OrderHistoryEntity toEntity(OrderHistory orderHistory){
        OrderHistoryEntity orderHistoryEntity = new OrderHistoryEntity();

        orderHistoryEntity.setId(orderHistory.getId());
        orderHistoryEntity.setAmount(orderHistory.getAmount());
        orderHistoryEntity.setDiscount(orderHistory.getDiscount());
        orderHistoryEntity.setRole(orderHistory.getRole());
        orderHistoryEntity.setOrderDateTime(orderHistory.getOrderDateTime());
        orderHistoryEntity.setEmailCustomer(orderHistory.getEmailCustomer());
        orderHistoryEntity.setUserId(orderHistory.getUserId());
        orderHistoryEntity.setPhoneCustomer(orderHistory.getPhoneCustomer());
        orderHistoryEntity.setCustomerId(orderHistory.getCustomerId());
        orderHistoryEntity.setFullNameStaff(orderHistory.getFullNameStaff());
        orderHistoryEntity.setTotalPrice(orderHistory.getTotalPrice());
        orderHistoryEntity.setFullNameCustomer(orderHistory.getFullNameCustomer());
        return orderHistoryEntity;
    }
}
