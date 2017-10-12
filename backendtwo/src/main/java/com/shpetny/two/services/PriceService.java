package com.shpetny.two.services;

import com.shpetny.two.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

    private final PriceRepository repository;

    @Autowired
    public PriceService(PriceRepository repository) {
        this.repository = repository;
    }

    // TODO Нужно ли создовать еще одну цену
}
