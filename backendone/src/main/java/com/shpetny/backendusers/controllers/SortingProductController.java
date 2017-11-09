package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.models.ProductView;
import com.shpetny.backendusers.services.ProductService;
import com.shpetny.backendusers.services.ProductViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/sorting")
public class SortingProductController {

    private static final String NAME = "name";
    private static final String PRICE = "price";
    private static final String RATING = "rating";


    private final ProductViewService productViewService;
    private final ProductService productService;

    @Autowired
    public SortingProductController(ProductViewService productViewService, ProductService productService) {
        this.productViewService = productViewService;
        this.productService = productService;
    }

    @GetMapping
    public List<ProductView> getAllProductsByType(@RequestParam(name = "type") String type,
                                                  @RequestParam(name = "sort",required=false) String sort) {
        List<Product> products = productService.getAllProductByType(type);
        List<ProductView> productViewList = productViewService.buildingPriceView(products);
        if (sort.equals(NAME)) {
            productViewList.sort(Comparator.comparing(ProductView::getName));
        } else if (sort.equals(PRICE)) {
            productViewList.sort(Comparator.comparing(ProductView::getPrice).reversed());
        } else if (sort.equals(RATING)) {
            productViewList.sort(Comparator.comparing(ProductView::getRating).reversed());
        }
        return productViewList;
    }
}
