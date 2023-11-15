package com.example.admin.Repository;

import com.example.admin.Entity.OrderDetailEntity;
import com.example.admin.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {
//    List<OrderDetailEntity> findOrderDetailEntitiesByOrderEntity(Optional<OrderEntity> orderEntity);

}
