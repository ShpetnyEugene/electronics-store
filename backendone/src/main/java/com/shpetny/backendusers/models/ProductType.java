package com.shpetny.backendusers.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private long productId;

    public ProductType() {
    }

    public ProductType(String name, long productId) {
        this.name = name;
        this.productId = productId;
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

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productId=" + productId +
                '}';
    }
}
