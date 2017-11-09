package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.models.ProductView;
import com.shpetny.backendusers.services.ProductService;
import com.shpetny.backendusers.services.ProductViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductViewService service;
    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService, ProductViewService service) {
        this.productService = productService;
        this.service = service;
    }

    @GetMapping
    public List<ProductView> getAllProductsByType(@RequestParam("type") String type) {
        List<Product> products = productService.getAllProductByType(type);
        return service.buildingPriceView(products);
    }
}
