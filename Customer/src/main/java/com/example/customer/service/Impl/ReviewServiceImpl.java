package com.example.customer.service.Impl;

import com.example.customer.converter.ReviewConverter;
import com.example.customer.domain.Review;
import com.example.customer.entity.ProductEntity;
import com.example.customer.repository.ProductRepository;
import com.example.customer.repository.ReviewRepository;
import com.example.customer.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviewByProduct(Long productId) {
        return reviewRepository.findAllByProductEntity(
                productRepository.findById(productId).orElseThrow())
                .stream()
                .map(ReviewConverter::toModel)
                .toList();
    }
}
