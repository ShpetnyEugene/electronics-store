package com.shpetny.backendusers.services;

import com.shpetny.backendusers.models.Features;
import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.models.ProductView;
import com.shpetny.backendusers.persistance.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductViewService productViewService;

    private Set<Product> products = new HashSet<>();

    @Autowired
    public ProductService(ProductRepository productRepository, ProductViewService productViewService) {
        this.productRepository = productRepository;
        this.productViewService = productViewService;
    }

    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(long id) {
        if (products.size() > 4) {
            products.remove(products.iterator().next());
            products.add(productRepository.findById(id));
        } else {
            products.add(productRepository.findById(id));
        }
        return productRepository.findById(id);
    }

    public boolean updateProduct(Product product) {
        if (product.getId() == 0) {
            productRepository.save(product);
            return true;
        } else {
            productRepository.save(product);
            return true;
        }
    }

    public List<ProductView> getTopProduct() {
        return productViewService.buildingPriceView(productRepository.findTopByRating());
    }

    public List<ProductView> getLastProduct() {
        return productViewService.buildingPriceView(new ArrayList<>(products));
    }

    public void deleteProductById(long id) {
        productRepository.delete(id);
    }

    public void decrementAmountProducts(List<Product> products) {
        for (Product product : products) {
            product.setAmount(product.getAmount() - 1);
            productRepository.save(product);
        }
    }

    public List<Product> getAllProductByType(String name) {
        return productRepository.findByTypeName(name);
    }



    public List<Product> sortByRating(List<Product> products){

        Collections.sort(products,new Comparator<Product>(){
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getRating(),o2.getRating());
            }
        });
        return  products;
    }

    public List<Product> getProducts(List<Features> features) {
        List<Long> ids = new ArrayList<>();
        for (Features features1 : features) {
            ids.add(features1.getId());
        }
        return productRepository.getProduct(ids);
    }
}
