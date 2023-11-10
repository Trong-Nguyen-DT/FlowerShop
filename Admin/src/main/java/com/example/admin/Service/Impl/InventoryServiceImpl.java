package com.example.admin.Service.Impl;


import com.example.admin.Converter.InventoryConverter;
import com.example.admin.Domain.Inventory;
import com.example.admin.Repository.InventoryRepository;
import com.example.admin.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll().stream().map(InventoryConverter::toModel).toList();
    }
}
