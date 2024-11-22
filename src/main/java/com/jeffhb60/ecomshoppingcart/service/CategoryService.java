package com.jeffhb60.ecomshoppingcart.service;

import com.jeffhb60.ecomshoppingcart.dto.CategoryResponse;
import com.jeffhb60.ecomshoppingcart.model.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponse getAllCategories();
    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
