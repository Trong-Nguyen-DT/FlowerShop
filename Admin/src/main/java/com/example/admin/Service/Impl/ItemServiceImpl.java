package com.example.admin.Service.Impl;

import com.example.admin.Converter.ItemConverter;
import com.example.admin.Domain.Item;
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
}
