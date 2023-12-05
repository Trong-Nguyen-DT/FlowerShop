package com.example.admin.Converter;

import com.example.admin.Domain.Category;
import com.example.admin.Domain.Review;
import com.example.admin.Entity.CategoryEntity;
import com.example.admin.Entity.ReviewEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryConverter {
    public static Category toModel(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        category.setImage(categoryEntity.getImage());
        category.setDeleted(categoryEntity.isDeleted());
        category.setDetail(categoryEntity.getDetail());
//        category.setProducts(categoryEntity.getProductEntities().stream().map(ProductConverter::toModel).toList());
        return category;
    }

    public static CategoryEntity toEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(category.getName());
        categoryEntity.setImage(category.getImage());
        categoryEntity.setDeleted(false);
        categoryEntity.setDetail(category.getDetail());
        return categoryEntity;
    }

    public static List<CategoryEntity> toEntityList(List<Category> categories) {
        return categories.stream()
                .map(CategoryConverter::toEntity)
                .collect(Collectors.toList());
    }
}
