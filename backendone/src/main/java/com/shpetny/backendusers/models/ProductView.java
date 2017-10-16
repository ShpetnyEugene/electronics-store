package com.shpetny.backendusers.models;


import java.util.List;

public class ProductView {

    private long id;
    private String name;
    private double price;
    private long amount;
    private String description;
    private double rating;
    private List<String> images;

    public ProductView() {
    }

    public ProductView(long id, String name, double price, long amount, String description, double rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.rating = rating;
    }

    public ProductView(String name, double price, long amount, String description, double rating) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.rating = rating;
    }

    public ProductView(String name, double price, long amount, String description, double rating, List<String> images) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.rating = rating;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
