package com.example.admin.Controller.Staff;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("staff")
public class StaffHomeController {
    @GetMapping()
    public String showStaffHome(){
        return "Staff/StaffHome";
    }
}
