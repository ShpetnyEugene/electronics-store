package com.shpetny.backendusers.services;

import com.shpetny.backendusers.models.Features;
import com.shpetny.backendusers.persistance.FeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeaturesService {

    private final FeaturesRepository featuresRepository;

    @Autowired
    public FeaturesService(FeaturesRepository featuresRepository) {
        this.featuresRepository = featuresRepository;
    }

    public List<Features> getAllFeaturesByProduct(long productId){
        return featuresRepository.getAllFeaturesByProduct(String.valueOf(productId));
    }

    public List<Features> getAllFeatures(){
        return featuresRepository.getAllFeatures();
    }

}
