package com.example.admin.Service;

import com.example.admin.Domain.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItem();
    void addItem(Item item);

    Item getItemById(Long itemId);

    void updateItem(Item item);

    void deleteItemById(Long itemId);

    void restoreItemById(Long itemId);
}
