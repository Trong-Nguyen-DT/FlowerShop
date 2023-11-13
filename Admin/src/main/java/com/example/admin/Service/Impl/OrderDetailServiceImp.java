package com.example.admin.Service.Impl;

import com.example.admin.Entity.OrderDetailEntity;
import com.example.admin.Entity.OrderEntity;
import com.example.admin.Repository.OrderDetailRepository;
import com.example.admin.Service.OrderDetailService;
import com.example.admin.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDetailServiceImp implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Override
    public List<OrderDetailEntity> findByOrder(Long orderId) {
        List<OrderDetailEntity> list = orderDetailRepository.findByOrder(orderId);
        return list;
    }
}
