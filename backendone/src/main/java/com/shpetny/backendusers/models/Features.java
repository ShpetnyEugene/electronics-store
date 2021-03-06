package com.shpetny.backendusers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String value;


    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST})
    @JoinTable(name = "FeaturesToProduct",
            joinColumns = @JoinColumn(name = "featuresId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "productId", referencedColumnName = "id"))
    @JsonIgnore
    private List<Product> products;

    public Features() {
    }

    public Features(long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;

    }

    public Features(String name, String value) {
        this.name = name;
        this.value = value;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Features features = (Features) o;

        if (id != features.id) return false;
        if (name != null ? !name.equals(features.name) : features.name != null) return false;
        return value != null ? value.equals(features.value) : features.value == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Features{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value +
                '}';
    }
}
