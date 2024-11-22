package com.jeffhb60.ecomshoppingcart.service;

import com.jeffhb60.ecomshoppingcart.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
}
