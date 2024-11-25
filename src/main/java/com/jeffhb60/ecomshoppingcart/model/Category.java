package com.jeffhb60.ecomshoppingcart.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
@NoArgsConstructor
public class Category {

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @NotBlank
    @Size(min = 1, message = "Category must contain at least 1 characters")
    @Column(name = "category_name")
    private String categoryName;
}
