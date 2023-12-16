package com.example.admin.Service;

import com.example.admin.Domain.Category;
import com.example.admin.Domain.CategoryData;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();

//    List<Category> getAllCategoriesByProductId(Long productId);
    boolean addCategory(Category category);
    Category getCategoryById(Long categoryId);

    void updateCategory(Category category);
    void deleteCategoryById(Long categoryId);
    void restoreCategoryById(Long categoryId);
    List<CategoryData> getAllCategoryData();
}
