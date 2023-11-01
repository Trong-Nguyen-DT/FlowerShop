package com.example.admin.Converter;

import com.example.admin.Domain.Item;
import com.example.admin.Entity.ItemEntity;

public class ItemConverter {
    public static Item toModel(ItemEntity itemEntity) {
        Item item = new Item();
        item.setId(itemEntity.getId());
        item.setName(itemEntity.getName());
        item.setDeleted(item.isDeleted());
        return item;
    }
}
