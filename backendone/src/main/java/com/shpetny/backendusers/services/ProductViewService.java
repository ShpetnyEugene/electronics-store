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

    private QuotePrice quotePrice = new QuotePrice();

    /**
     * This method make product view with product and price obtain with other application
     *
     * @return List building ProductView with Product and Price
     */
    public List<ProductView> buildingPriceView(List<Product> products) {
        List<ProductView> productViews = new ArrayList<>();
        for (Product product : products) {
            productViews.add(
                    new ProductView(product.getId(),
                            product.getName(),
                            quotePrice.getPrice(product.getId()).getPrice().get(0).getValue(),
                            product.getAmount(),
                            product.getDescription(),
                            product.getRating(),
                            product.getImages()));
        }
        return productViews;
    }

//
//    public List<ProductView> getPriceViewByTypeProduct(String name) {
//        List<Product> products = productService.getAllProductByType(name);
//        List<ProductView> productViews = new ArrayList<>();
//        for (Product product : products) {
//            productViews.add(
//                    new ProductView(product.getId(),
//                            product.getName(),
//                            quotePrice.getPrice(product.getId()).getPrice().get(0).getValue(),
//                            product.getAmount(),
//                            product.getDescription(),
//                            product.getRating(),
//                            product.getImages()));
//        }
//        return productViews;
//    }
}
