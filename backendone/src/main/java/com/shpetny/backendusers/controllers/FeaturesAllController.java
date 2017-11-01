package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Features;
import com.shpetny.backendusers.services.FeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/features/all")
public class FeaturesAllController {

    private final FeaturesService featuresService;

    @Autowired
    public FeaturesAllController(FeaturesService featuresService) {
        this.featuresService = featuresService;
    }

    @GetMapping
    public List<Features> getFeaturesAll(){
        return featuresService.getAllFeatures();
    }

}
