package com.shpetny.store.services;

import com.shpetny.store.pojos.Price;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    private QuotePrice quotePrice = new QuotePrice();

    public List<Price> getPrice(long id) {
        return  quotePrice.getPrice(id).getPrice();
    }

    public void updatePrice(long id, long newValue) {
        quotePrice.updatePrice(id, newValue);
    }


    public void printPrices(List<Price> prices) {
        for (Price price : prices) {
            System.out.println(price);
        }
    }

}
