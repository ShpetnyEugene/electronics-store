package com.shpetny.backendusers.persistance;

import com.shpetny.backendusers.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findById(long id);

    List<Product> findByTypeName(String name);


    // TODO
    @Query("SELECT * FROM PRODUCTS LIMIT 50 ORDER BY RATING ASC")
    List<Product> findTopByRating();
//    List<Product> 

}
