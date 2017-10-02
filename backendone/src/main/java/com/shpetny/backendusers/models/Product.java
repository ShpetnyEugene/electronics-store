package com.shpetny.backendusers.models;


import javax.persistence.*;
import java.time.LocalDate;
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
    private long priceId;
    private String name;
    private String description;
    private double rating;


    private long productType;
    @ElementCollection(targetClass = String.class)
    private List<String> image;

    public Product() {

    }


}
