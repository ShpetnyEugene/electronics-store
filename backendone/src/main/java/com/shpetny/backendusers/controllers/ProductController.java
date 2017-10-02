package com.shpetny.backendusers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products/{[productName}")
public class ProductController {

    @PutMapping
    public void updateProduct(){
        // TODO
    }
}
