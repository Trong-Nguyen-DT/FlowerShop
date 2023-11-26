package com.example.admin.Controller.Admin;

import com.example.admin.Domain.ImportGood;
import com.example.admin.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.admin.Service.ImportGoodsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin/importGood")
public class ImportGoodsController {
    @Autowired
    private ImportGoodsService importGoodsService;

    @Autowired
    private ItemService itemService;
    @GetMapping()
    public String listImportGoods(Model model) {
        model.addAttribute("importGoods", importGoodsService.getAllImportGoods());
        model.addAttribute("items", itemService.getAllItem());
        return "Admin/ImportGoodsAdmin";
    }
    @GetMapping("add")
    public String showAddImportGoods(Model model) {
        model.addAttribute("importGood", new ImportGood());
        return "Admin/ImportGoodsAdmin";
    }

    @PostMapping("add")
    public String addImportGoods(@ModelAttribute ImportGood importGood) {
        importGoodsService.addImportGoods(importGood);
        return "redirect:/admin/importGood";
    }
//    @GetMapping("/searchItemNames")
//    public List<String> searchItemNames(@RequestParam String item) {
//        // Gọi service để truy vấn cơ sở dữ liệu và trả về danh sách các tên item phù hợp.
//        return importGoodsService.searchItemNames(item);
//    }
}
