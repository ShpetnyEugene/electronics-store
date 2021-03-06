package com.shpetny.backendusers.persistance;

import com.shpetny.backendusers.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

    @Query(value = "SELECT * FROM PRODUCT  ORDER BY RATING DESC LIMIT 4",nativeQuery = true)
    List<Product> findTopByRating();


    @Query(value = "SELECT * FROM PRODUCT WHERE ID IN (SELECT PRODUCT_ID FROM FEATURES_TO_PRODUCT WHERE FEATURES_ID IN :list);",nativeQuery = true)
    public List<Product> getProduct(@Param("list") List<Long> longs);


}
