package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.models.ProductView;
import com.shpetny.backendusers.services.ProductService;
import com.shpetny.backendusers.services.ProductViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products/{productId}")
public class ProductController {

    private final ProductService service;
    private final ProductViewService productViewService;

    @Autowired
    public ProductController(ProductService service, ProductViewService productViewService) {
        this.service = service;
        this.productViewService = productViewService;
    }

    @GetMapping
    @ResponseBody
    public ProductView getProduct(@PathVariable String productId) {
        return productViewService.buildingPriceView(Arrays.asList(service.getProductById(Long.parseLong(productId)))).get(0);

    }

    @PostMapping
    @ResponseBody
    public void buyProduct(@RequestBody List<Product> products) {
        for (Product product : products) {
            product.setAmount(product.getAmount() - 1);
            service.updateProduct(product);
        }
    }
}
