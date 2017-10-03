package com.shpetny.backendusers.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class PurchaseHistory {
    @Id
    private long id;
    private LocalDate date;
    private long productId;

}
