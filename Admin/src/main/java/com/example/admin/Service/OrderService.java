package com.example.admin.Service;


import com.example.admin.Domain.AmountData;
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
    double getAllTotalByTime(LocalDateTime of, LocalDateTime now);
    List<OrderEntity> findAllList(Date from, Date to);
    OrderEntity addNote(OrderNote orderNote);
    OrderEntity findById(Long id);
    void updateStatusOrder(OrderStatus orderStatus, Long orderId);
    List<AmountData> getAmountByMonth();
    List<OrderHistory> getOrderByMonth(int month, int year);
    double getPercentCompare(double totalThisMonth, double totalLastMonth);
    Long getTotalAmountByOrder(List<OrderHistory> orderHistories);

    Long getTotalRevenueByTime(LocalDateTime startTime, LocalDateTime endTime);
}
