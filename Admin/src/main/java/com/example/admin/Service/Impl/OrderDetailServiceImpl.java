package com.example.admin.Service.Impl;


import com.example.admin.Entity.*;
import com.example.admin.Repository.*;
import com.example.admin.Service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetailEntity> findByOrder(Long orderId) {
        List<OrderDetailEntity> list = orderDetailRepository.findByOrder(orderId);
        return list;
    }

}
