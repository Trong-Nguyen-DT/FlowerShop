package com.example.admin.Service;



import com.example.admin.Domain.Product;
import com.example.admin.Entity.OrderDetailEntity;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailEntity> findByOrder(Long orderId);
    List<Product> getTop4Product();
}
