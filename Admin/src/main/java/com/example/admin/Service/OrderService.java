package com.example.admin.Service;

import com.example.admin.Converter.AmountData;
import com.example.admin.Domain.Customer;
import com.example.admin.Domain.Order;
import com.example.admin.Domain.OrderHistory;
import com.example.admin.Domain.User;
import com.example.admin.Entity.OrderEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    List<OrderHistory> getAllOrderHistory();

}
