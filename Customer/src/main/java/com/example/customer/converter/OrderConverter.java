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

//    public static OrderHistory orderEntityToOrderHistory(OrderEntity entity) {
//        OrderHistory orderHistory = new OrderHistory();
//        orderHistory.setId(entity.getId());
//        orderHistory.setOrderDateTime(entity.getOrderDateTime());
//        orderHistory.setTotalPrice(entity.getTotalPrice());
//        orderHistory.setDiscount(entity.getDiscount());
//        orderHistory.setAmount(entity.getAmount());
//        orderHistory.setUserId(entity.getUserEntity().getId());
//        orderHistory.setFullNameStaff(entity.getUserEntity().getFullName());
//        orderHistory.setRole(entity.getUserEntity().getRole());
//        orderHistory.setCustomerId(entity.getCustomerEntity().getId());
//        orderHistory.setFullNameCustomer(entity.getCustomerEntity().getFullName());
//        orderHistory.setPhoneCustomer(entity.getCustomerEntity().getPhone());
//        orderHistory.setEmailCustomer(entity.getCustomerEntity().getEmail());
//        orderHistory.setOrderDetailHistories(entity.getOrderDetails().stream().map(OrderDetailConverter::OrderDetailEntitytoOrderDetailHistory).toList());
//        return orderHistory;
//    }

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
