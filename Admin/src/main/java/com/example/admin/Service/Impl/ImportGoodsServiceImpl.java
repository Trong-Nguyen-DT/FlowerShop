package com.example.admin.Service.Impl;

import com.example.admin.Converter.ImportGoodsConverter;
import com.example.admin.Converter.OrderHistoryConverter;
import com.example.admin.Domain.ImportGood;
import com.example.admin.Domain.OrderHistory;
import com.example.admin.Repository.ImportGoodsRepository;
import com.example.admin.Service.ImportGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImportGoodsServiceImpl implements ImportGoodsService {
    @Autowired
    private ImportGoodsRepository importGoodsRepository;
    @Override
    public List<ImportGood> getAllImportGoods() {
        return importGoodsRepository.findAll().stream().map(ImportGoodsConverter::toModel).toList();
    }

    @Override
    public List<ImportGood> getImportGoodByTime(LocalDateTime startTime, LocalDateTime endTime) {
        return importGoodsRepository.findImportGoodsEntitiesByTimeImportBetween(startTime, endTime).stream().map(ImportGoodsConverter::toModel).toList();
    }
    public double getTotalImportAmountByTime(LocalDateTime startTime, LocalDateTime endTime) {
        try {
            return importGoodsRepository.getTotalImportAmountByTime(startTime, endTime);
        } catch (Exception ex) {
            // Handle the exception or log it
            return 0;
        }
    }
//    public List<String> searchItemNames(String term) {
//        // Thực hiện truy vấn cơ sở dữ liệu để lấy danh sách tên item phù hợp.
//        return itemRepository.findItemNamesByTerm(term);
//    }
}
