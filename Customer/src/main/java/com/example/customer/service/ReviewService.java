package com.example.customer.service;

import com.example.customer.domain.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviewByProduct(Long productId);

    void addReview(Review review, String name);
}
