package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Features;
import com.shpetny.backendusers.services.FeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/features")
public class FeaturesController {

    private final FeaturesService featuresService;

    @Autowired
    public FeaturesController(FeaturesService featuresService) {
        this.featuresService = featuresService;
    }

    @GetMapping
    public List<Features> getAllFeaturesById(@RequestParam long productId) {
        return featuresService.getAllFeaturesByProduct(productId);
    }
}
