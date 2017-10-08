package com.shpetny.backendusers.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;
    private long productId;
    private long userId;

    public Cart() {
    }

}

