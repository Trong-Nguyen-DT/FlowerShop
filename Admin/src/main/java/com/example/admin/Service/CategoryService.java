package com.example.admin.Service;

import com.example.admin.Domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();

    void addCategory(Category category);
}
