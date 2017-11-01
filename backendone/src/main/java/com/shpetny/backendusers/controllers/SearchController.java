package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.ProductView;
import com.shpetny.backendusers.services.ProductService;
import com.shpetny.backendusers.services.ProductViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/search")
@RestController
public class SearchController {

    private final ProductViewService service;
    private final ProductService productService;

    @Autowired
    public SearchController(ProductViewService service, ProductService productService) {
        this.service = service;
        this.productService = productService;
    }

    @GetMapping
    public List<ProductView> getAllProductsByType() {
        return service.buildingPriceView(productService.getAllProduct());
    }
}
