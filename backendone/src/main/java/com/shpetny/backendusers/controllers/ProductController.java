package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Product;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/{[productName}")
public class ProductController {

    @PutMapping
    public void updateProduct(@RequestBody Product product) {

        // TODO
    }
}
