package com.shpetny.adminspanel.controller;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@RestController
@ComponentScan("com.shpetny.backendusers")
@RequestMapping("/admin")
public class AdminController {

    private final ProductService service;

    @Autowired
    public AdminController(ProductService service) {
        this.service = service;
    }


    /**
     * This method return all products from database
     *
     * @return List products which return all product from data base
     */
    @GetMapping
    public List<Product> getAllPrice() {
        return service.getAllProduct();
    }

    /**
     * Thi method update product in Data Base
     *
     * @param product - Product obtain with frontend which need update from Data Base
     */
    @PostMapping
    public boolean updateOrCreateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }


    /**
     * Thi method delete product form Data Base
     *
     * @param product - Product obtain with frontend which need delete from Data Base
     */
    @DeleteMapping
    public void deleteProduct(@RequestBody Product product) {
        service.deleteProductById(product.getId());
    }
}
