package com.example.admin.Service;

import com.example.admin.Domain.ImportGood;

import java.time.LocalDateTime;
import java.util.List;

public interface ImportGoodsService {
    List<ImportGood> getImportGoodByTime(LocalDateTime startTime, LocalDateTime endTime);
    List<ImportGood> getAllImportGoods();
    double getTotalImportAmountByTime(LocalDateTime startTime, LocalDateTime endTime);
}
