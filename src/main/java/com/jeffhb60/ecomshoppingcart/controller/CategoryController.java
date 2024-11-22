package com.jeffhb60.ecomshoppingcart.controller;

import com.jeffhb60.ecomshoppingcart.dto.CategoryDTO;
import com.jeffhb60.ecomshoppingcart.dto.CategoryResponse;
import com.jeffhb60.ecomshoppingcart.model.Category;
import com.jeffhb60.ecomshoppingcart.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static com.jeffhb60.ecomshoppingcart.config.AppConstants.PAGE_NUMBER;
import static com.jeffhb60.ecomshoppingcart.config.AppConstants.PAGE_SIZE;

@RestController
@AllArgsConstructor
@RequestMapping("api/")
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping("public/categories")
    public ResponseEntity<CategoryResponse> getAllCategories(

            @RequestParam(name = "pageNumber",
            defaultValue = PAGE_NUMBER,
            required = false)
            Integer pageNumber,

            @RequestParam(name = "pageSize",
                    defaultValue = PAGE_SIZE,
                    required = false)
            Integer pageSize)
    {
        CategoryResponse categoryResponse;
        categoryResponse = categoryService.getAllCategories(pageNumber, pageSize);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping("public/categories")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO savedCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId) {
        CategoryDTO savedCategoryDTO = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);
    }

    @PutMapping("public/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,
                                                 @PathVariable Long categoryId) {
        CategoryDTO savedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);
    }
}
