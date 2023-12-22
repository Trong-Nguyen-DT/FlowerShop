package com.example.customer.service;

import com.example.customer.domain.OrderHistory;

import java.util.List;

public interface OrderHistoryService
{
    Long addOrder(String name, Long orderId);

    List<OrderHistory> getOrderByCustomer(String name);

    OrderHistory getOrderByOrderId(Long orderId, String name);

    void setReviewed(Long orderId);
}
