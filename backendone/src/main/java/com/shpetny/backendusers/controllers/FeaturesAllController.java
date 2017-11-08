package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Features;
import com.shpetny.backendusers.models.ProductView;
import com.shpetny.backendusers.services.FeaturesService;
import com.shpetny.backendusers.services.ProductService;
import com.shpetny.backendusers.services.ProductViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/features/all")
public class FeaturesAllController {

    private final FeaturesService featuresService;
    private final ProductService productService;
    private final ProductViewService productViewService;

    @Autowired
    public FeaturesAllController(FeaturesService featuresService, ProductService productService, ProductViewService productViewService) {
        this.featuresService = featuresService;
        this.productService = productService;
        this.productViewService = productViewService;
    }

    @GetMapping
    public Map<String, List<Features>> getFeaturesByProduct() {

        List<Features> features = featuresService.getAllFeatures();
        Map<String, List<Features>> map = new HashMap<>();
        features.forEach(feature -> {
            String key = feature.getName().trim();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(feature);
        });
        return map;
    }


    @PostMapping
    public List<ProductView> findProduct(@RequestParam String features) {
        String[] strings = features.split(",");
        List<Features> featuresList = new ArrayList<>();
        String[] srf;
        for (String string : strings) {
            srf = string.split("=");
            featuresList.add(new Features(srf[0], srf[1]));
        }
        return productViewService.buildingPriceView(productService.getProducts(featuresService.getFeaturesByValues(featuresList)));
    }
}
