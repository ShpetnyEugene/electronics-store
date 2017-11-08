package com.shpetny.adminspanel.controllers;


import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.models.Type;
import com.shpetny.backendusers.services.ProductService;
import com.shpetny.backendusers.services.TypeViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/panel")
public class AdminController {

    private final TypeViewService typeViewService;
    private final ProductService service;

    /**
     * This method return all products from database
     *
     * @return List products which return all product from data base
     */
    @GetMapping
    public List<Product> getAllPrice() {
        return service.getAllProduct();
    }


    @Autowired
    public AdminController(ProductService service, TypeViewService typeViewService) {
        this.service = service;
        this.typeViewService = typeViewService;
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


    @PutMapping
    public void changeView(@RequestBody Type type) {
        typeViewService.updateType(type.getType());
    }
}
