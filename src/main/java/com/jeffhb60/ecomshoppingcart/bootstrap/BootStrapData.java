package com.jeffhb60.ecomshoppingcart.bootstrap;

import com.jeffhb60.ecomshoppingcart.model.Category;
import com.jeffhb60.ecomshoppingcart.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class BootStrapData implements CommandLineRunner {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Category> categories = null;
        if (categoryRepository.count() == 0) {

            categories = List.of(
                    new Category("Electronics"),
                    new Category("Clothing"),
                    new Category("Home Decor"),
                    new Category("Toys"),
                    new Category("Books"),
                    new Category("Shoes"),
                    new Category("Beauty Products"),
                    new Category("Sports Equipment"),
                    new Category("Kitchen Appliances"),
                    new Category("Outdoor Gear"),
                    new Category("Pet Supplies"),
                    new Category("Health and Wellness"),
                    new Category("Stationery"),
                    new Category("Gaming"),
                    new Category("Automotive"),
                    new Category("Jewelry"),
                    new Category("Art Supplies"),
                    new Category("Baby Products"),
                    new Category("Musical Instruments"),
                    new Category("Furniture"),
                    new Category("Groceries"),
                    new Category("Office Supplies"),
                    new Category("Seasonal Items"),
                    new Category("Bags and Accessories"),
                    new Category("Craft Supplies"),
                    new Category("Garden Supplies"),
                    new Category("Lighting"),
                    new Category("Travel Essentials"),
                    new Category("Fitness Gear"),
                    new Category("Electronics Accessories"),
                    new Category("Luxury Items"),
                    new Category("Cleaning Supplies"),
                    new Category("DIY Tools"),
                    new Category("Wine and Spirits"),
                    new Category("Gourmet Foods")
            );
        }
        assert categories != null;
        categoryRepository.saveAll(categories);

    }
}


