package com.example.admin.Service;

import com.example.admin.Domain.Category;
import com.example.admin.Domain.ImportGood;

import java.util.List;

public interface ImportGoodsService {
    List<ImportGood> getAllImportGoods();

    void addImportGoods(ImportGood importGood);

//    List<String> searchItemNames(String term);

}
