package com.example.admin.Service;

import com.example.admin.Domain.ImportGoodsDetail;

import java.util.List;

public interface ImportGoodsDetailService {
    List<ImportGoodsDetail> getImportGoodsDetailByImportGoodsId(Long importGoodsId);
}
