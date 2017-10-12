package com.shpetny.two;

import com.shpetny.two.pojos.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {
    Price findPriceById(long id);

}
