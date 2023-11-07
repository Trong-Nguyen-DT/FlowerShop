package com.example.admin.Controller.Admin;

import com.example.admin.Domain.User;
import com.example.admin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/staff")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping()
//    public String showListStaff(Model model) {
//        List<User> users = userService.getAllStaff();
//        return "Admin/StaffAdmin";
//    }

    @GetMapping()
    public String listStaff(Model model) {
        model.addAttribute("users", userService.getAllStaff());
        return "Admin/StaffAdmin";
    }

    @GetMapping("add")
    public String showAddStaff(Model model) {
        model.addAttribute("user", new User());
        return "Admin/AddStaffAdmin";
    }

    @PostMapping("add")
    public String addStaff(@ModelAttribute User user) {
        userService.addStaff(user);
        return "redirect:/admin/staff";
    }

    @GetMapping("edit/{id}")
    public String showEditStaff(@PathVariable String id, Model model) {
        Long userId = Long.parseLong(id);
        model.addAttribute("user", userService.getStaffById(userId));
        return "Admin/EditStaffAdmin";
    }

    @PostMapping("edit")
    public String editStaff(@ModelAttribute User user) {
        userService.updateStaff(user);
        return "redirect:/admin/staff";
    }

    @GetMapping("delete/{id}")
    public String deleteStaff(@PathVariable String id) {
        Long userId = Long.parseLong(id);
        userService.deleteStaffById(userId);
        return "redirect:/admin/staff";
    }

    @GetMapping("restore")
    public String listStaffRestore(Model model) {
        model.addAttribute("users", userService.getAllStaff());
        return "Admin/RestoreStaffAdmin";
    }

    @GetMapping("restore/{id}")
    public String restoreStaff(@PathVariable String id) {
        Long userId = Long.parseLong(id);
        userService.restoreStaffById(userId);
        return "redirect:/admin/staff/restore";
    }
}
