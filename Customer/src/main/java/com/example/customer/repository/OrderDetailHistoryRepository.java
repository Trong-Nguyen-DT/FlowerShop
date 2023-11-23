package com.example.customer.repository;

import com.example.customer.entity.OrderDetailHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailHistoryRepository extends JpaRepository<OrderDetailHistoryEntity, Long> {
}
