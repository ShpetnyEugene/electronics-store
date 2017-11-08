package com.shpetny.backendusers.persistance;


import com.shpetny.backendusers.models.Features;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeaturesRepository extends CrudRepository<Features, Long> {

    @Query(value = "SELECT * FROM FEATURES WHERE ID IN (SELECT FEATURES_ID FROM FEATURES_TO_PRODUCT WHERE PRODUCT_ID = :productId)", nativeQuery = true)
    List<Features> getAllFeaturesByProduct(@Param("productId") String productId);

    @Query(value = "SELECT * FROM FEATURES",nativeQuery = true)
    List<Features> getAllFeatures();

    List<Features> getFeaturesByValueIn(List<String> features);
}
