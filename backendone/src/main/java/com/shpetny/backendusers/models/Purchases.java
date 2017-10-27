package com.shpetny.backendusers.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate date;

    @ManyToMany
    @JoinTable(name = "PurchasesToProduct",
            joinColumns = @JoinColumn(name = "purchasesId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "productId", referencedColumnName = "id"))
    private List<Product> products;

    // TODO
//    private long productId;


    @ManyToMany
    @JoinTable(name = "PurchasesToUsers",
            joinColumns = @JoinColumn(name = "purchasesId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"))
        private List<User> users;
//    private long userId;

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

    //    public Purchases(LocalDate date, long productId, long userId) {
//        this.date = date;
//        this.productId = productId;
//        this.userId = userId;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    public long getProductId() {
//        return productId;
//    }
//
//    public void setProductId(long productId) {
//        this.productId = productId;
//    }
//
//    public long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(long userId) {
//        this.userId = userId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Purchases purchases = (Purchases) o;
//
//        if (id != purchases.id) return false;
//        if (productId != purchases.productId) return false;
//        if (userId != purchases.userId) return false;
//        return date != null ? date.equals(purchases.date) : purchases.date == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = (int) (id ^ (id >>> 32));
//        result = 31 * result + (date != null ? date.hashCode() : 0);
//        result = 31 * result + (int) (productId ^ (productId >>> 32));
//        result = 31 * result + (int) (userId ^ (userId >>> 32));
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "Purchases{" +
//                "id=" + id +
//                ", date=" + date +
//                ", productId=" + productId +
//                ", userId=" + userId +
//                '}';
//    }
}
