package com.example.admin.Controller.Admin;

import com.example.admin.Domain.AmountData;
import com.example.admin.Domain.CategoryData;
import com.example.admin.Domain.Item;
import com.example.admin.Service.CategoryService;
import com.example.admin.Service.ItemService;
import com.example.admin.Service.OrderService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ApiController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderService orderService;

    @GetMapping("api/items")
    public List<Item> getAllItem() {
        return itemService.getAllItem();
    }

    @GetMapping("/category-data")
    public ResponseEntity<List<CategoryData>> getCategoryData() {
        List<CategoryData> data = categoryService.getAllCategoryData(); // Lấy dữ liệu từ cơ sở dữ liệu
        return ResponseEntity.ok(data);
    }

    @GetMapping("/amount-data")
    public ResponseEntity<List<AmountData>> getAmount() {
        List<AmountData> data = orderService.getAmountByMonth();

        return ResponseEntity.ok(data);
    }

}
