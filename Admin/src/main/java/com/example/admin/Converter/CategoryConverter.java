package com.example.admin.Converter;

import com.example.admin.Domain.Category;
import com.example.admin.Entity.CategoryEntity;

public class CategoryConverter {
    public static Category toModel(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        category.setDeleted(categoryEntity.isDeleted());
//        category.setProducts(categoryEntity.getProductEntities().stream().map(ProductConverter::toModel).toList());
        return category;
    }

    public static CategoryEntity toEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(category.getName());
        categoryEntity.setDeleted(false);
        return categoryEntity;
    }
}
