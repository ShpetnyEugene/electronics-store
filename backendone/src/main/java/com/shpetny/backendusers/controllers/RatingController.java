package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.services.ProductService;
import com.shpetny.backendusers.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;
    private final ProductService productService;

    @Autowired
    public RatingController(RatingService ratingService, ProductService productService) {
        this.ratingService = ratingService;
        this.productService = productService;
    }

    @PostMapping
    public double updateRatingInProduct(@RequestBody Product product) {
        ratingService.updateRating(product.getId(), product.getRating());
        return productService.getProductById(product.getId()).getRating();
    }
}
