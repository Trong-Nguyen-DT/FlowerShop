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

    @Override
    public Category getCategoryById(Long categoryId) {
        return CategoryConverter.toModel(categoryRepository.findById(categoryId).orElseThrow());
    }

    @Override
    public void updateCategory(Category category) {
        CategoryEntity categoryEntity = categoryRepository.findById(category.getId()).orElseThrow();
        categoryEntity.setName(category.getName());
        categoryEntity.setImage(category.getImage());
        categoryEntity.setDetail(category.getDetail());
        categoryRepository.save(categoryEntity);
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId).orElseThrow();
        categoryEntity.setDeleted(true);
        categoryRepository.save(categoryEntity);
    }

    @Override
    public void restoreCategoryById(Long categoryId) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId).orElseThrow();
        categoryEntity.setDeleted(false);
        categoryRepository.save(categoryEntity);
    }
}
