package com.example.admin.Converter;

import com.example.admin.Domain.Inventory;
import com.example.admin.Entity.InventoryEntity;

public class InventoryConverter {
    public static Inventory toModel(InventoryEntity inventoryEntity) {
        Inventory inventory = new Inventory();
        inventory.setId(inventoryEntity.getId());
        inventory.setQuantity(inventoryEntity.getQuantity());

        // Chuyển đổi thông tin từ ItemEntity (nếu có)
        inventory.setItemId(ItemConverter.toModel(inventoryEntity.getItemEntity()));
        return inventory;
    }
    public static InventoryEntity toEntity(Inventory inventory) {
        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setId(inventory.getId());
        inventoryEntity.setQuantity(inventory.getQuantity());

        inventoryEntity.setItemEntity(ItemConverter.toEntity(inventory.getItemId()));
        return inventoryEntity;
    }
}
