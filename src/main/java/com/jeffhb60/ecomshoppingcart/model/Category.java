package com.jeffhb60.ecomshoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Category {
    private Long categoryId;
    private String categoryName;
}