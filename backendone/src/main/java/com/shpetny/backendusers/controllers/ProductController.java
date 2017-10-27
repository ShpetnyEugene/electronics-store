package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Product;
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
    public Product getProduct(@RequestBody Product product) {
        return service.getProductById(product.getId());
    }

    @PostMapping
    @ResponseBody// TODO CHECK THIS METHOD
    public void buyProduct(@RequestBody List<Product> products) {
        for (Product product : products) {
            product.setAmount(product.getAmount() - 1);
            service.updateProduct(product);
        }
    }
}
