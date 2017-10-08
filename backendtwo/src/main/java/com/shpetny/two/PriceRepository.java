package com.shpetny.two;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {
    Price findPriceById(long id);

}
