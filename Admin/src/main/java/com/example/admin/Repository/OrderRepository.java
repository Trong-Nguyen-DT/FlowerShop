package com.example.admin.Repository;

import com.example.admin.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
//    List<OrderEntity> findOrderEntityByConfirmed(Boolean confirmed);

}
