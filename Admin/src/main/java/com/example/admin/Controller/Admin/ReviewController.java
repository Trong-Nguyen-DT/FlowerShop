package com.example.admin.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.admin.Service.ReviewService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping()
    public String listReview(Model model) {
        model.addAttribute("reviews", reviewService.getAllReview());
        return "Admin/ReviewAdmin";
    }
}
