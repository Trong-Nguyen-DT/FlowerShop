package com.example.admin.Service;

import com.example.admin.Entity.OrderDetailEntity;
import com.example.admin.Entity.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {

    public List<OrderDetailEntity> findByOrder(Long orderId);
}
