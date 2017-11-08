package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.ProductView;
import com.shpetny.backendusers.services.ProductService;
import com.shpetny.backendusers.services.TypeViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final ProductService productService;
    private final TypeViewService typeViewService;

    @Autowired
    public HomeController(ProductService productService, TypeViewService typeViewService) {
        this.productService = productService;
        this.typeViewService = typeViewService;
    }

    @GetMapping
    public List<ProductView> getViewHome() {
        if (typeViewService.getType().getType() == 1) {
            return productService.getTopProduct();
        } else if (typeViewService.getType().getType() == 2) {
            return productService.getLastProduct();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
