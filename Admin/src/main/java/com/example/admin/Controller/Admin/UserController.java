package com.example.admin.Controller.Admin;

import com.example.admin.Domain.User;
import com.example.admin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/staff")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String showListStaff(Model model) {
        List<User> users = userService.getAllStaff();
        return "Admin/StaffAdmin";
    }
}
