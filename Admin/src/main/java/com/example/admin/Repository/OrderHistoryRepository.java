package com.example.admin.Repository;

import com.example.admin.Entity.OrderHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderHistoryRepository extends JpaRepository<OrderHistoryEntity, Long> {
    List<OrderHistoryEntity> findOrderHistoryEntitiesByOrderDateTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

    @Query("SELECT o FROM OrderHistoryEntity o WHERE MONTH(o.orderDateTime) = :month AND YEAR(o.orderDateTime) = :year")
    List<OrderHistoryEntity> findOrdersByMonthAndYear(int month, int year);
    @Query("SELECT COALESCE(SUM(o.totalPrice), 0) FROM OrderHistoryEntity o WHERE o.orderDateTime BETWEEN :startTime AND :endTime")
    double getTotalRevenueByTime(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
    List<OrderHistoryEntity> findOrderHistoryEntitiesByUserIdAndOrderDateTimeBetween(Long id, LocalDateTime start, LocalDateTime end);
}
