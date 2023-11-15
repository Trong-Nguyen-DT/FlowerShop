package com.example.admin.Service.Impl;

import com.example.admin.Converter.ItemConverter;
import com.example.admin.Domain.Item;
import com.example.admin.Entity.ItemEntity;
import com.example.admin.Repository.ItemRepository;
import com.example.admin.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll().stream().map(ItemConverter::toModel).toList();
    }
    @Override
    public void addItem(Item item) {
        itemRepository.save(ItemConverter.toEntity(item));
    }

    @Override
    public Item getItemById(Long itemId) {
        return ItemConverter.toModel(itemRepository.findById(itemId).orElseThrow());
    }

    @Override
    public void updateItem(Item item) {
        ItemEntity itemEntity = itemRepository.findById(item.getId()).orElseThrow();
        itemEntity.setName(item.getName());
        itemRepository.save(itemEntity);
    }

    @Override
    public void deleteItemById(Long itemId) {
        ItemEntity itemEntity = itemRepository.findById(itemId).orElseThrow();
        itemEntity.setDeleted(true);
        itemRepository.save(itemEntity);
    }

    @Override
    public void restoreItemById(Long itemId) {
        ItemEntity itemEntity = itemRepository.findById(itemId).orElseThrow();
        itemEntity.setDeleted(false);
        itemRepository.save(itemEntity);
    }
}
