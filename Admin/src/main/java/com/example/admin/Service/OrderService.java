package com.example.admin.Service;


import com.example.admin.Domain.OrderHistory;
import com.example.admin.Domain.OrderNote;
import com.example.admin.Entity.OrderEntity;
import com.example.admin.enums.OrderStatus;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    List<OrderHistory> getAllOrderHistory();

    List<OrderHistory> getOrderByTime(LocalDateTime startTime, LocalDateTime endTime);

    List<OrderEntity> findAllList(Date from, Date to);

    OrderEntity addNote(OrderNote orderNote);

    OrderEntity findById(Long id);

    void updateStatusOrder(OrderStatus orderStatus, Long orderId);

}
