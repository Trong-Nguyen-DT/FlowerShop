package com.example.customer.converter;

import com.example.customer.domain.Review;
import com.example.customer.entity.ReviewEntity;

public class ReviewConverter {
    public static Review toModel(ReviewEntity reviewEntity) {
        Review review = new Review();
        return review;
    }

}
