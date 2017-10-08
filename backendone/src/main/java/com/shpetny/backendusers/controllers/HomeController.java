package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.QuotePrice;
import com.shpetny.backendusers.models.Price;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public Price get(){
        Price p = new QuotePrice().getPriceById(1).getPrice();
        double id = p.getValue();
        return p;
    }
}
