package com.shpetny.backendusers.persistance;


import com.shpetny.backendusers.models.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart,Long> {
//    boolean addProduct()
}
