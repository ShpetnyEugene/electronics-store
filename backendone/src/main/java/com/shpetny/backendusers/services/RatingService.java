package com.shpetny.backendusers.services;

import com.shpetny.backendusers.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private final ProductService productService;

    @Autowired
    public RatingService(ProductService productService) {
        this.productService = productService;
    }

    public void updateRating(long productId, double rating) {
        Product product = productService.getProductById(productId);
        product.setRating((product.getRating() + rating) / 2);
        productService.updateProduct(product);
    }
}
