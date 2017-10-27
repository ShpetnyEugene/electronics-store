package com.shpetny.backendusers.persistance;

import com.shpetny.backendusers.models.Purchases;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasesRepository extends CrudRepository<Purchases,Long> {
    void deleteByUsers(long id);  // TODO
}
