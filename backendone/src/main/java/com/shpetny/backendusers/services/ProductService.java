package com.shpetny.backendusers.services;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.persistance.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    public ProductService(@Qualifier("productRepository") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;


    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(long id) {
        return productRepository.findById(id);
    }

    // TODO CHECK THIS  METHOD
    public boolean updateProduct(Product product) {
        if (product.getId() == 0) {
            productRepository.save(product);
            return true;
        } else {
            Product product1 = new Product(product.getName(),
                    product.getAmount(), product.getDescription(), product.getRating());
            product1.setId(product.getId());
            productRepository.delete(product);
            productRepository.save(product1);
            return true;
        }
    }

    public List<Product> getTopProduct(){
        return productRepository.findTopByRating();
//    return null;
    }

    public void deleteProductById(long id) {
        productRepository.delete(id);
    }


    public void decrementAmountProducts(List<Product> products){
        for(Product product: products){
            product.setAmount(product.getAmount()-1);
        }
    }



    public List<Product> getAllProductByType(String name) {
        return productRepository.findByTypeName(name);
    }
}
