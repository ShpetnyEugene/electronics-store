package com.shpetny.two;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Price {
    @Id
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
}
