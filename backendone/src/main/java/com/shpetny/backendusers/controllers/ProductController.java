package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.models.ProductType;
import com.shpetny.backendusers.models.ProductView;
import com.shpetny.backendusers.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/{productName}")
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping
    @ResponseBody
    public Product getProduct(@RequestBody Product product){
        return  service.getProductById(product.getId());

    }
}
