package com.shpetny.backendusers.models;


public class PurchasesView {

    private String date;
    private String name;
    private double price;
    private long amount;
    private String description;
    private double rating;
    private String images;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public PurchasesView() {
    }

    public PurchasesView(String date, String name, double price, long amount, String description, double rating, String images) {
        this.date = date;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.rating = rating;
        this.images = images;
    }
}

