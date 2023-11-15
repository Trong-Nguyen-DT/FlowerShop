package com.example.admin.Converter;

import com.example.admin.Domain.Order;
import com.example.admin.Domain.OrderHistory;
import com.example.admin.Entity.OrderEntity;
import com.example.admin.Entity.OrderHistoryEntity;

public class OrderConverter {
    public static Order toModel(OrderEntity orderEntity) {
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setAmount(orderEntity.getAmount());
        order.setOrderDateTime(orderEntity.getOrderDateTime());
        order.setConfirmed(orderEntity.getConfirmed());
        order.setStatus(orderEntity.getStatus());
        order.setDiscount(orderEntity.getDiscount());
        order.setTotalPrice(orderEntity.getTotalPrice());

        order.setUser(UserConverter.toModel(orderEntity.getUserEntity()));
        order.setCustomer(CustomerConverter.toModel(orderEntity.getCustomerEntity()));

        return order;
    }

    public static OrderHistory OrderEntitytoOrderHistory(OrderEntity orderEntity){
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setId(orderEntity.getId());
        orderHistory.setOrderDateTime(orderEntity.getOrderDateTime());
        orderHistory.setTotalPrice(orderEntity.getTotalPrice());
        orderHistory.setDiscount(orderEntity.getDiscount());
        orderHistory.setAmount(orderEntity.getAmount());
        orderHistory.setUserId(orderEntity.getUserEntity().getId());
        orderHistory.setFullNameStaff(orderEntity.getUserEntity().getFullName());
        orderHistory.setRole(orderEntity.getUserEntity().getRole());
        orderHistory.setCustomerId(orderEntity.getCustomerEntity().getId());
        orderHistory.setFullNameCustomer(orderEntity.getCustomerEntity().getFullName());
        orderHistory.setPhoneCustomer(orderEntity.getCustomerEntity().getPhone());
        orderHistory.setEmailCustomer(orderEntity.getCustomerEntity().getEmail());
        orderHistory.setOrderDetailHistories(orderEntity.getOrderDetails().stream().map(OrderDetailConverter::OrderDetailEntitytoOrderDetailHistory).toList());

        return orderHistory;
    }
//    public static OrderHistory toModelOrderHistory(OrderHistoryEntity entity) {
//        OrderHistory orderHistory = new OrderHistory();
//        orderHistory.setId(entity.getId());
//        orderHistory.setOrderDateTime(entity.getOrderDateTime());
//        orderHistory.setTotalPrice(entity.getTotalPrice());
//        orderHistory.setDiscount(entity.getDiscount());
//        orderHistory.setAmount(entity.getAmount());
//        orderHistory.setUserId(entity.getUserId());
//        orderHistory.setFullNameStaff(entity.getFullNameStaff());
//        orderHistory.setRole(entity.getRole());
//        orderHistory.setCustomerId(orderHistory.getCustomerId());
//        orderHistory.setFullNameCustomer(entity.getFullNameCustomer());
//        orderHistory.setPhoneCustomer(entity.getPhoneCustomer());
//        orderHistory.setEmailCustomer(entity.getEmailCustomer());
//        orderHistory.setOrderDetailHistories(entity.getOrderDetailHistoryEntities().stream().map(OrderDetailConverter::toOrderDetailHistory).toList());
//        return orderHistory;
//    }
}
