package com.example.admin.Converter;

import com.example.admin.Domain.Review;
import com.example.admin.Entity.ReviewEntity;

import java.util.List;
import java.util.stream.Collectors;


public class ReviewConverter {
    public static Review toModel(ReviewEntity reviewEntity) {
        Review review = new Review();
        review.setId(reviewEntity.getId());
        review.setName(reviewEntity.getName());
        review.setDate(reviewEntity.getDate());
        review.setRate(reviewEntity.getRate());
        review.setContent(reviewEntity.getContent());

        review.setProduct(ProductConverter.toModel(reviewEntity.getProductEntity()));
//        review.setCustomer(CustomerConverter.toModel(reviewEntity.getCustomerEntity()));

        return review;
    }

    public static ReviewEntity toEntity(Review review) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setId(review.getId());
        reviewEntity.setName(review.getName());
        reviewEntity.setDate(review.getDate());
        reviewEntity.setRate(review.getRate());
        reviewEntity.setContent(review.getContent());

        reviewEntity.setCustomerEntity(CustomerConverter.toEntity(review.getCustomer()));
        reviewEntity.setProductEntity(ProductConverter.toEntity(review.getProduct()));

        return reviewEntity;
    }
    public static List<ReviewEntity> toEntityList(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewConverter::toEntity)
                .collect(Collectors.toList());
    }
}
