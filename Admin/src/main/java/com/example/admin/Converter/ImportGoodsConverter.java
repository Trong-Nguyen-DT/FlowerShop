package com.example.admin.Converter;

import com.example.admin.Domain.ImportGood;
import com.example.admin.Entity.ImportGoodsEntity;

public class ImportGoodsConverter {
    public static ImportGood toModel(ImportGoodsEntity importGoodsEntity) {
        ImportGood importGood = new ImportGood();
        importGood.setId(importGoodsEntity.getId());
        importGood.setTimeImport(importGoodsEntity.getTimeImport());
        importGood.setStaff_id(importGoodsEntity.getStaff_id());
        // Chuyển đổi thông tin từ ItemEntity (nếu có)
//        importGood.setItem(ItemConverter.toModel(importGoodsEntity.getItemEntity()));
        importGood.setTotalPrice(importGood.getTotalPrice());

        return importGood;
    }
    public static ImportGoodsEntity toEntity(ImportGood importGood) {
        ImportGoodsEntity importGoodsEntity = new ImportGoodsEntity();
        importGoodsEntity.setId(importGood.getId());
        importGoodsEntity.setTimeImport(importGood.getTimeImport());
        importGoodsEntity.setStaff_id(importGood.getStaff_id());
//        importGoodsEntity.setItemEntity(ItemConverter.toEntity(importGood.getItem()));
        importGoodsEntity.setTotalPrice(importGood.getTotalPrice());

        return importGoodsEntity;
    }
}
