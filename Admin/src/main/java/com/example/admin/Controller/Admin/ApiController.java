package com.example.admin.Controller.Admin;

import com.example.admin.Domain.Item;
import com.example.admin.Service.ItemService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ApiController {

    @Autowired
    private ItemService itemService;

    @GetMapping("api/items")
    public List<Item> getAllItem() {
        return itemService.getAllItem();
    }
}
