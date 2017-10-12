package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.services.ProductService;
import com.shpetny.backendusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public String createProduct() {
        return null;
    }


    @GetMapping
    @ResponseBody
    public List<Product> getAllProducts(){
       return productService.getAllProduct();
    }

}
