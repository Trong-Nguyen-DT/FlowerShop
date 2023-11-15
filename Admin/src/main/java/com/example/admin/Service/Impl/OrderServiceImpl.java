package com.example.admin.Service.Impl;


import com.example.admin.Converter.OrderHistoryConverter;
import com.example.admin.Domain.OrderHistory;
import com.example.admin.Repository.OrderHistoryRepository;
import com.example.admin.Repository.OrderRepository;
import com.example.admin.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    @Override
    public List<OrderHistory> getAllOrderHistory() {
        return orderHistoryRepository.findAll().stream().map(OrderHistoryConverter::toModel).toList();
    }


}
