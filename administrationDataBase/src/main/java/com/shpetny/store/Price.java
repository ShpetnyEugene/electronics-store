package com.shpetny.store;


import java.util.List;

public class Price {
    private long id;
    private long value;
    private List<Long> productsId;

    public Price(long id, long value, List<Long> productsId) {
        this.id = id;
        this.value = value;
        this.productsId = productsId;
    }
}
