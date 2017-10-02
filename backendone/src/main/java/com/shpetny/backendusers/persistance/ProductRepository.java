package com.shpetny.backendusers.persistance;

import com.shpetny.backendusers.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findById(long id);


}
