package com.example.admin.Converter;

import com.example.admin.Domain.Order;
import com.example.admin.Domain.OrderHistory;
import com.example.admin.Entity.OrderEntity;
import com.example.admin.Entity.OrderHistoryEntity;

public class OrderConverter {
    public static OrderHistory toModelHistory(OrderHistoryEntity orderHistoryEntity) {
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setId(orderHistoryEntity.getId());
        orderHistory.setAmount(orderHistoryEntity.getAmount());
        orderHistory.setOrderDateTime(orderHistoryEntity.getOrderDateTime());
        orderHistory.setFullNameStaff(orderHistoryEntity.getFullNameStaff());
        orderHistory.setEmailCustomer(orderHistoryEntity.getEmailCustomer());
        orderHistory.setPhoneCustomer(orderHistoryEntity.getPhoneCustomer());
        orderHistory.setDiscount(orderHistoryEntity.getDiscount());
        orderHistory.setTotalPrice(orderHistoryEntity.getTotalPrice());
        orderHistory.setUserId(orderHistoryEntity.getUserId());
        orderHistory.setCustomerId(orderHistoryEntity.getCustomerId());
        orderHistory.setFullNameCustomer(orderHistoryEntity.getFullNameCustomer());
        orderHistory.setOrderDetailHistories(orderHistoryEntity.getOrderDetailHistoryEntities().stream().map(OrderDetailHistoryConverter::toModel).toList());

//        orderHistory.setUser(UserConverter.toModel(orderHistoryEntity.getUserEntity()));
//        orderHistory.setCustomer(CustomerConverter.toModel(orderHistoryEntity.getCustomerEntity()));

        return orderHistory;
    }

    public static Order toModel(OrderEntity orderEntity) {
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setAmount(orderEntity.getAmount());
        order.setDiscount(orderEntity.getDiscount());
        order.setTotalPrice(orderEntity.getTotalPrice());

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
        orderHistory.setCustomerId(orderEntity.getCustomerEntity().getId());
        orderHistory.setFullNameCustomer(orderEntity.getCustomerEntity().getFullName());
        orderHistory.setPhoneCustomer(orderEntity.getCustomerEntity().getPhone());
        orderHistory.setEmailCustomer(orderEntity.getCustomerEntity().getEmail());
        orderHistory.setOrderDetailHistories(orderEntity.getOrderDetails().stream().map(OrderDetailConverter::OrderDetailEntitytoOrderDetailHistory).toList());

        return orderHistory;
    }
}
