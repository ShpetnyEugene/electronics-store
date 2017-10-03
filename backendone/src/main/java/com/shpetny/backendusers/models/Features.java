package com.shpetny.backendusers.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Features {
    @Id
    private long id;
    private String name;
    private String value;
    private long productId;

    public Features() {
    }

    public Features(long id, String name, String value, long productId) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.productId = productId;
    }

    public Features(String name, String value, long productId) {
        this.name = name;
        this.value = value;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
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

        Features features = (Features) o;

        if (id != features.id) return false;
        if (productId != features.productId) return false;
        if (name != null ? !name.equals(features.name) : features.name != null) return false;
        return value != null ? value.equals(features.value) : features.value == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Features{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", productId=" + productId +
                '}';
    }
}
