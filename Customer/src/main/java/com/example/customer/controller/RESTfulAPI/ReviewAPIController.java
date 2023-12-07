package com.example.customer.controller.RESTfulAPI;


import com.example.customer.domain.Review;
import com.example.customer.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/review")
public class ReviewAPIController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("{productId}")
    public String getReviewByProduct(@PathVariable Long productId) {
        List<Review> reviews = reviewService.getAllReviewByProduct(productId);
        return "";
    }
}
