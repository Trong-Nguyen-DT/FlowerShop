package com.example.admin.Converter;

import com.example.admin.Domain.Order;
import com.example.admin.Domain.Review;
import com.example.admin.Entity.OrderEntity;

public class OrderConverter {
    public static Order toModel(OrderEntity orderEntity) {
        Order order = new Order();
        review.setId(reviewEntity.getId());
        review.setName(reviewEntity.getName());
        review.setDate(reviewEntity.getDate());
        review.setRate(reviewEntity.getRate());
        review.setContent(reviewEntity.getContent());

        review.setProduct(ProductConverter.toModel(reviewEntity.getProductEntity()));
        review.setCustomer(CustomerConverter.toModel(reviewEntity.getCustomerEntity()));

        return order;
    }

    public static ReviewEntity toEntity(Review review) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setId(review.getId());
        reviewEntity.setName(reviewEntity.getName());
        reviewEntity.setDate(reviewEntity.getDate());
        reviewEntity.setRate(review.getRate());
        reviewEntity.setContent(review.getContent());

        reviewEntity.setCustomerEntity(CustomerConverter.toEntity(review.getCustomer()));
        reviewEntity.setProductEntity(ProductConverter.toEntity(review.getProduct()));

        return reviewEntity;
    }
}
