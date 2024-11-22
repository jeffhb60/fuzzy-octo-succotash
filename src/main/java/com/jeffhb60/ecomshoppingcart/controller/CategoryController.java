package com.jeffhb60.ecomshoppingcart.controller;

import com.jeffhb60.ecomshoppingcart.model.Category;
import com.jeffhb60.ecomshoppingcart.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping("api/public/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("api/public/categories")
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return "Category added successfully";
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {
        String status = categoryService.deleteCategory(categoryId);
        return status;
    }

}
