package com.shpetny.backendusers.models;

import javax.persistence.*;
import java.util.List;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    @JoinTable(name = "CartToProduct",
    joinColumns = @JoinColumn(name = "cardId", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "productId",referencedColumnName = "id"))
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    private long userId;


    public Cart() {
    }

//    public Cart(long productId, long userId) {
//        this.productId = productId;
//        this.userId = userId;
//    }
//
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public long getProductId() {
//        return productId;
//    }
//
//    public void setProductId(long productId) {
//        this.productId = productId;
//    }
//
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Cart cart = (Cart) o;
//
//        if (id != cart.id) return false;
//        if (productId != cart.productId) return false;
//        return userId == cart.userId;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = (int) (id ^ (id >>> 32));
//        result = 31 * result + (int) (productId ^ (productId >>> 32));
//        result = 31 * result + (int) (userId ^ (userId >>> 32));
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "Cart{" +
//                "id=" + id +
//                ", productId=" + productId +
//                ", userId=" + userId +
//                '}';
//    }
}

