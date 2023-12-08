package com.example.admin.Service.Impl;

import com.example.admin.Converter.RevenueConverter;
import com.example.admin.Domain.Revenue;
import com.example.admin.Repository.RevenueRepository;
import com.example.admin.Service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueServiceImpl implements RevenueService {
    @Autowired
    private RevenueRepository revenueRepository;

    @Override
    public List<Revenue> getAllRevenue() {
        return revenueRepository.findAll().stream().map(RevenueConverter::toModel).toList();
    }
}
