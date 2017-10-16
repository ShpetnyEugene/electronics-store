package com.shpetny.adminspanel.controller;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan("com.shpetny.backendusers")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService service;

    @PostMapping
    public boolean updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }
}
