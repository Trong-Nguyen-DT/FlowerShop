package com.example.admin.Service.Impl;


import com.example.admin.Converter.CategoryConverter;
import com.example.admin.Converter.ItemConverter;
import com.example.admin.Converter.ProductDetailConverter;
import com.example.admin.Domain.Category;
import com.example.admin.Domain.CategoryData;
import com.example.admin.Domain.ProductDetail;
import com.example.admin.Entity.CategoryEntity;
import com.example.admin.Entity.ItemEntity;
import com.example.admin.Entity.OrderDetailHistoryEntity;
import com.example.admin.Repository.CategoryRepository;
import com.example.admin.Repository.OrderDetailHistoryRepository;
import com.example.admin.Repository.ProductRepository;
import com.example.admin.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderDetailHistoryRepository orderDetailHistoryRepository;


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
    @Override
    public List<CategoryData> getAllCategoryData() {
        List<CategoryData> categoryDataList = new ArrayList<>();
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        List<OrderDetailHistoryEntity> orderDetailHistoryEntities = orderDetailHistoryRepository.findAll();

        for (CategoryEntity categoryEntity : categoryEntities) {
            CategoryData categoryData = new CategoryData();
            categoryData.setQuantity(0);

            for (OrderDetailHistoryEntity productEntity : orderDetailHistoryEntities) {
                // Assuming that getCategories() returns a List<CategoryEntity> in ProductEntity
                List<CategoryEntity> productCategories = productRepository.findById(productEntity.getProductId())
                        .orElseThrow()
                        .getCategoryEntities();

                if (productCategories != null && !productCategories.isEmpty()) {
                    // Get the ID of the current category
                    Long currentCategoryId = categoryEntity.getId();

                    // Check if the current category's ID is in the list of product categories
                    if (productCategories.stream().anyMatch(category -> category.getId().equals(currentCategoryId))) {
                        categoryData.setCategoryName(categoryEntity.getName());
                        categoryData.setQuantity(categoryData.getQuantity() + productEntity.getQuantity());
                    }
                }
            }

            categoryDataList.add(categoryData);
        }

        return categoryDataList;
    }

}
