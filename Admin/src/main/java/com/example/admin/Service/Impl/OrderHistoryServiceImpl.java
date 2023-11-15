package com.example.admin.Service.Impl;

import com.example.admin.Converter.OrderHistoryConverter;
import com.example.admin.Domain.OrderHistory;
import com.example.admin.Repository.OrderHistoryRepository;
import com.example.admin.Service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    @Override
    public List<OrderHistory> getAllOrderHistory() {
        return orderHistoryRepository.findAll().stream().map(OrderHistoryConverter::toModel).toList();
    }
}
