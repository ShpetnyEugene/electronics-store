package com.shpetny.backendusers.services;

import com.shpetny.backendusers.QuotePrice;
import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.models.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductViewService {

    @Autowired
    private ProductService productService;

    private QuotePrice quotePrice = new QuotePrice();


    public List<ProductView> getAllViewPrices(){
        return null;
    }

    public List<ProductView> buildingPriceView(){
        List<Product> products = productService.getAllProduct();

        List<ProductView> productViews = new ArrayList<>();

        for(Product product: products){
            productViews.add(new ProductView(product.getName(),
                    quotePrice.getPrice(product.getId()).getPrice().get(0).getValue(),
                    product.getAmount(),
                    product.getDescription(),
                    product.getRating(),
                    product.getImages()));
        }
        return productViews;
    }
}
