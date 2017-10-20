package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.ProductType;
import com.shpetny.backendusers.models.ProductView;
import com.shpetny.backendusers.services.ProductService;
import com.shpetny.backendusers.services.ProductViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductViewService service;

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping
    public String createProduct() {
        return null;
    }


    @PostMapping
    public List<ProductView> getAllProductsByType(@RequestBody ProductType type) {
        return service.getPriceViewByTypeProduct(type.getName());
    }

    @GetMapping
    @ResponseBody
    public List<ProductView> getAllProducts() {
        return service.buildingPriceView();
    }

}
