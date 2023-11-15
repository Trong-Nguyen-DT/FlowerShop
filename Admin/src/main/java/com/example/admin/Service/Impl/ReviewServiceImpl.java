package com.example.admin.Service.Impl;

import com.example.admin.Domain.Review;
import com.example.admin.Repository.ReviewRepository;
import com.example.admin.Converter.ReviewConverter;
import com.example.admin.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository ReviewRepository;
    @Override
    public List<Review> getAllReview() {
        return ReviewRepository.findAll().stream().map(ReviewConverter::toModel).toList();
    }
}
