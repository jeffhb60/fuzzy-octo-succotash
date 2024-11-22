package com.jeffhb60.ecomshoppingcart.repositories;

import com.jeffhb60.ecomshoppingcart.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryName(@NotBlank @Size(min = 1, message = "Category must contain at least 5 characters") String categoryName);
}
