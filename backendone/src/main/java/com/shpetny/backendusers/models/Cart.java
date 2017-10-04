package com.shpetny.backendusers.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
    @Id
    private long id;
    private long productId;
}
