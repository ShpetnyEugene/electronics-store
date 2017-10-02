package com.shpetny.backendusers.models;

import javax.persistence.*;
import java.util.List;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double value;
    @ElementCollection(targetClass=Long.class)
    private List<Long> productsId;

    public Price() {
    }

    public Price(long id, double value, List<Long> productsId) {
        this.id = id;
        this.value = value;
        this.productsId = productsId;
    }

    public Price(double value, List<Long> productsId) {
        this.value = value;
        this.productsId = productsId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public List<Long> getProductsId() {
        return productsId;
    }

    public void setProductsId(List<Long> productsId) {
        this.productsId = productsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        if (id != price.id) return false;
        if (Double.compare(price.value, value) != 0) return false;
        return productsId != null ? productsId.equals(price.productsId) : price.productsId == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (productsId != null ? productsId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", value=" + value +
                ", productsId=" + productsId +
                '}';
    }
}
