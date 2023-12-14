package com.example.admin.Service.Impl;


import com.example.admin.Converter.CategoryConverter;
import com.example.admin.Converter.ItemConverter;
import com.example.admin.Converter.ProductDetailConverter;
import com.example.admin.Domain.Category;
import com.example.admin.Domain.ProductDetail;
import com.example.admin.Entity.CategoryEntity;
import com.example.admin.Entity.ItemEntity;
import com.example.admin.Repository.CategoryRepository;
import com.example.admin.Repository.ProductRepository;
import com.example.admin.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll().stream().map(CategoryConverter::toModel).toList();
    }

//    public List<Category> getAllCategoriesByProductId(Long productId) {
//        return categoryRepository.findAllByProductEntities(productRepository.findById(productId).orElseThrow()).stream().map(CategoryConverter::toModel).toList();
//    }
    @Override
    public boolean addCategory(Category category) {
        Optional<CategoryEntity> optionalCategory = categoryRepository.findAll().stream()
                .filter(entity -> entity.getName().equals(category.getName()))
                .findFirst();
        if (optionalCategory.isPresent()) {
            return false;
        }else {
            categoryRepository.save(CategoryConverter.toEntity(category));
            return true;
        }

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
