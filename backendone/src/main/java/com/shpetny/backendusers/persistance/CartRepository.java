package com.shpetny.backendusers.persistance;

import com.shpetny.backendusers.models.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {

    // TODO SPRING DATA QUERY
}
