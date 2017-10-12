package com.shpetny.backendusers.services;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.persistance.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAllProduct(){
        return (List<Product>) productRepository.findAll();
    }

      public Product getProductById(long id){
        return productRepository.findById(id);
    }
}
