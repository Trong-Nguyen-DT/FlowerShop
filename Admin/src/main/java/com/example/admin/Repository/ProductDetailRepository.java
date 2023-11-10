package com.example.admin.Repository;

import com.example.admin.Entity.ProductDetailEntity;
import com.example.admin.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long> {
    List<ProductDetailEntity> findAllByProductEntity(ProductEntity productEntity);
}
