package com.shpetny.backendusers.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate date;
    private long productId;
    private long userId;

    public Purchases() {
    }

    public Purchases(LocalDate date, long productId, long userId) {
        this.date = date;
        this.productId = productId;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchases purchases = (Purchases) o;

        if (id != purchases.id) return false;
        if (productId != purchases.productId) return false;
        if (userId != purchases.userId) return false;
        return date != null ? date.equals(purchases.date) : purchases.date == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Purchases{" +
                "id=" + id +
                ", date=" + date +
                ", productId=" + productId +
                ", userId=" + userId +
                '}';
    }
}
