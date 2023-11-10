package com.example.admin.Controller.Admin;


import com.example.admin.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @GetMapping()
    public String listInventory(Model model) {
        model.addAttribute("inventories", inventoryService.getAllInventory());
        return "Admin/InventoryAdmin";
    }
}
