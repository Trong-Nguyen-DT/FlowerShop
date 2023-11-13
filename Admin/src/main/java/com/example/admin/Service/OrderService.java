package com.example.admin.Service;

import com.example.admin.Domain.Order;
import com.example.admin.Domain.OrderNote;
import com.example.admin.Entity.OrderEntity;
import com.example.admin.enums.OrderStatus;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface OrderService {

    public List<OrderEntity> findAllList(Date from,Date to);

    public OrderEntity addNote(OrderNote orderNote);

    public OrderEntity findById(Long id);

    public void updateStatusOrder(OrderStatus orderStatus, Long orderId);
}
