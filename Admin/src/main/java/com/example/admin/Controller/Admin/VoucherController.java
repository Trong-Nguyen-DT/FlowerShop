package com.example.admin.Controller.Admin;

import com.example.admin.Domain.Voucher;
import com.example.admin.Service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin/voucher")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @GetMapping()
    public String listVoucher(Model model) {
        model.addAttribute("vouchers", voucherService.getAllVoucher());
        return "Admin/VoucherAdmin";
    }

    @GetMapping("add")
    public String showAddVoucher(Model model) {
        model.addAttribute("voucher", new Voucher());
        return "Admin/AddVoucherAdmin";
    }
    @PostMapping("add")
    public String addVoucher(@ModelAttribute Voucher voucher) {
        voucherService.addVoucher(voucher);
        return "redirect:/admin/voucher";
    }
    @GetMapping("edit/{id}")
    public String showEditVoucher(@PathVariable String id, Model model) {
        Long voucherId = Long.parseLong(id);
        model.addAttribute("voucher", voucherService.getVoucherById(voucherId));
        return "Admin/EditVoucherAdmin";
    }
    @PostMapping("edit")
    public String editVoucher(@ModelAttribute Voucher voucher) {
        voucherService.updateVoucher(voucher);
        return "redirect:/admin/voucher";
    }
}
