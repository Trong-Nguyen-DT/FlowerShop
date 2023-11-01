package com.example.admin.Repository;

import com.example.admin.Entity.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long> {
}
