package com.jeffhb60.ecomshoppingcart.model;

import com.jeffhb60.ecomshoppingcart.repositories.CategoryRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import static com.jeffhb60.ecomshoppingcart.config.AppConstants.DEFAULT_IMAGE_NAME;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "name")
    private String productName;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "discount")
    private double discount;

    @Column(name = "special_price")
    private double specialPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User user;

    public Product(Long productId, String productName, String image, String description, Integer quantity, double price, double discount, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.image = image;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.specialPrice = calculateSpecialPrice(price, discount);
    }

    public Product(String productName, String description, Integer quantity, double price, double discount, Category category) {
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.image = DEFAULT_IMAGE_NAME;
        this.specialPrice = calculateSpecialPrice(price, discount);
    }

    private double calculateSpecialPrice(double price, double discount) {
        double specialPrice = price - price * discount * 0.01;
        return Math.round(specialPrice * 100.0) / 100.0;
    }
}
