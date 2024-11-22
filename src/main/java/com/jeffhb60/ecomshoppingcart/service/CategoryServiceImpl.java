package com.jeffhb60.ecomshoppingcart.service;

import com.jeffhb60.ecomshoppingcart.dto.CategoryDTO;
import com.jeffhb60.ecomshoppingcart.dto.CategoryResponse;
import com.jeffhb60.ecomshoppingcart.exceptions.APIException;
import com.jeffhb60.ecomshoppingcart.exceptions.ResourceNotFoundException;
import com.jeffhb60.ecomshoppingcart.model.Category;
import com.jeffhb60.ecomshoppingcart.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new APIException("There are no categories available in the database!");
        }

        List<CategoryDTO> categoryDTOS = categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        return categoryResponse;
    }

    @Override
    public void createCategory(Category category) {
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null) {
            throw new APIException("Category with the name " + category.getCategoryName() + " already exists!");
        }
        categoryRepository.save(category);

    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                        .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        categoryRepository.delete(category);
        return "Category with categoryId: " + categoryId + " deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);
        Category savedCategory;
        savedCategoryOptional.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;

    }
}
