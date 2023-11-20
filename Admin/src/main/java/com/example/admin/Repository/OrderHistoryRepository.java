package com.example.admin.Repository;

import com.example.admin.Entity.OrderHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderHistoryRepository extends JpaRepository<OrderHistoryEntity, Long> {
    List<OrderHistoryEntity> findOrderHistoryEntitiesByOrderDateTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

    @Query("SELECT o FROM OrderHistoryEntity o WHERE MONTH(o.orderDateTime) = :month AND YEAR(o.orderDateTime) = :year")
    List<OrderHistoryEntity> findOrdersByMonthAndYear(int month, int year);
    List<OrderHistoryEntity> findOrderHistoryEntitiesByUserIdAndOrderDateTimeBetween(Long id, LocalDateTime start, LocalDateTime end);
}
