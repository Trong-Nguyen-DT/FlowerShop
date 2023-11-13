package com.example.admin.Repository;

import com.example.admin.Entity.OrderDetailEntity;
import com.example.admin.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {

    @Query("select o from OrderDetailEntity o where o.orderEntity.id = ?1")
    public List<OrderDetailEntity> findByOrder(Long orderId);
}
