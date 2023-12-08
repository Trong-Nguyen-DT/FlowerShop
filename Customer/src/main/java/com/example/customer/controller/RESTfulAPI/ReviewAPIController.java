package com.example.customer.controller.RESTfulAPI;


import com.example.customer.domain.Review;
import com.example.customer.service.ReviewService;
import com.example.customer.validator.CustomerValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/review")
public class ReviewAPIController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private CustomerValidate customerValidate;

    @GetMapping("{productId}")
    public ResponseEntity<List<Review>> getReviewByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(reviewService.getAllReviewByProduct(productId));
    }

    @PostMapping("add-review")
    public ResponseEntity<List<Review>> addReview(@RequestBody Review review) {
        String name = customerValidate.validateCustomer();
        if (name == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        reviewService.addReview(review, name);
        return ResponseEntity.ok(reviewService.getAllReviewByProduct(review.getProductId()));
    }


}
