package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/purchases")
public class Purchases {

    @GetMapping
    public List<Product> getPurchases(){
        return null;
    }
}
