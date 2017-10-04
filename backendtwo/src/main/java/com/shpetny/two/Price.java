package com.shpetny.two;

import javax.persistence.*;
import java.util.List;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double value;
//    @ElementCollection(targetClass=Long.class)
//    private List<Long> productsId;

    public Price() {
    }

    public Price(long id, double value, List<Long> productsId) {
        this.id = id;
        this.value = value;
//        this.productsId = productsId;
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

//    public List<Long> getProductsId() {
//        return productsId;
//    }
//
//    public void setProductsId(List<Long> productsId) {
//        this.productsId = productsId;
//    }
}
