package com.shpetny.backendusers.persistance;

import com.shpetny.backendusers.models.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends CrudRepository<Price,Long>{

}
