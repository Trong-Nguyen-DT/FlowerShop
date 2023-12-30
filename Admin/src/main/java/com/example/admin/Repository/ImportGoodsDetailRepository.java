package com.example.admin.Repository;

import com.example.admin.Entity.ImportGoodsDetailEntity;
import com.example.admin.Entity.ImportGoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImportGoodsDetailRepository extends JpaRepository<ImportGoodsDetailEntity, Long> {
    List<ImportGoodsDetailEntity> findAllByImportGoodsEntity(ImportGoodsEntity importGoodsEntity);
}
