package com.shpetny.backendusers.models;

import javax.persistence.*;
import java.util.List;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private long price;
    private long amount;
    private String description;
    private double rating;
    @ElementCollection(targetClass = String.class)
    private List<String> images;

    public Product() {
    }

    // TODO SELECT * FROM product INNER JOIN productType ON product.id == productType.productId

    public Product(String name, long price, long amount, String description, double rating, long productTypeId, List<String> images) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.rating = rating;
        this.images = images;
    }

}
