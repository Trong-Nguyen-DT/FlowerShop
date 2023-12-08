package com.example.customer.service.Impl;

import com.example.customer.converter.ReviewConverter;
import com.example.customer.domain.Review;
import com.example.customer.entity.CustomerEntity;
import com.example.customer.entity.ReviewEntity;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.repository.ProductRepository;
import com.example.customer.repository.ReviewRepository;
import com.example.customer.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Review> getAllReviewByProduct(Long productId) {
        return reviewRepository.findAllByProductEntity(
                productRepository.findById(productId).orElseThrow())
                .stream()
                .map(ReviewConverter::toModel)
                .toList();
    }

    @Override
    public void addReview(Review review, String name) {
        CustomerEntity customerEntity = customerRepository.findByUsername(name).orElseThrow();
        reviewRepository.save(createReviewEntity(review, customerEntity));
    }

    private ReviewEntity createReviewEntity(Review review, CustomerEntity customerEntity) {
        ReviewEntity entity = new ReviewEntity();
        entity.setCustomerEntity(customerEntity);
        entity.setName(customerEntity.getFullName());
        entity.setDate(LocalDate.now());
        entity.setProductEntity(productRepository.findById(review.getProductId()).orElseThrow());
        entity.setRate(entity.getRate());
        entity.setContent(review.getContent());
        return entity;
    }
}
