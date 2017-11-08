package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Features;
import com.shpetny.backendusers.services.FeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/features")
public class FeaturesController {

    private final FeaturesService featuresService;

    @Autowired
    public FeaturesController(FeaturesService featuresService) {
        this.featuresService = featuresService;
    }

    @GetMapping
    public List<Features> getAllFeaturesById(@RequestParam long productId){
        return featuresService.getAllFeaturesByProduct(productId);
    }
}
