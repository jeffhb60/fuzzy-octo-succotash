package com.jeffhb60.ecomshoppingcart.repositories;

import com.jeffhb60.ecomshoppingcart.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
