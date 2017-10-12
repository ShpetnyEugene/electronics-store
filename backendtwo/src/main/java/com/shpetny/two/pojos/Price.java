package com.shpetny.two.pojos;

import javax.persistence.*;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double value;
    private long productId;


    public Price() {
    }

    public Price(double value, long productId) {
        this.value = value;
        this.productId = productId;
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

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        if (id != price.id) return false;
        if (Double.compare(price.value, value) != 0) return false;
        return productId == price.productId;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", value=" + value +
                ", productId=" + productId +
                '}';
    }
}
