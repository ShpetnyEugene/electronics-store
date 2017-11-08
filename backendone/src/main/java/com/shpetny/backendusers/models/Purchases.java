package com.shpetny.backendusers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonIgnore
    private LocalDate date;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "PurchasesToProduct",
            joinColumns = @JoinColumn(name = "purchasesId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "productId", referencedColumnName = "id"))
    private List<Product> products;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "PurchasesToUsers",
            joinColumns = @JoinColumn(name = "purchasesId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"))
    @JsonIgnore
        private List<User> users;

    public Purchases() {
    }

    public Purchases(LocalDate date, List<Product> products, List<User> users) {
        this.date = date;
        this.products = products;
        this.users = users;
    }

    public Purchases(List<Product> products) {
        this.products = products;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
