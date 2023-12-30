package com.example.admin.Service;

import com.example.admin.Domain.FlashSale;

import java.util.List;

public interface FlashSaleService {
    List<FlashSale> getAllFlashSale();

    boolean checkFlashSale(FlashSale flashSale);

    void addFlashSale(FlashSale flashSale);

    FlashSale getFlashSaleById(Long flashSaleId);

    void updateFlashSale(FlashSale flashSale);

    void deleteFlashSaleById(Long flashSaleId);

//    void restoreFlashSaleIdById(Long flashSaleId);
}
