package com.shpetny.backendusers.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Purchases {
    @Id
    private long id;
    private LocalDate date;
    private long productId;
    private long userId;

}
