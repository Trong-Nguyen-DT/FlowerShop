package com.example.admin.Service.Impl;


import com.example.admin.Converter.CategoryConverter;
import com.example.admin.Domain.Category;
import com.example.admin.Entity.CategoryEntity;
import com.example.admin.Repository.CategoryRepository;
import com.example.admin.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll().stream().map(CategoryConverter::toModel).toList();
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(CategoryConverter.toEntity(category));
    }
}
