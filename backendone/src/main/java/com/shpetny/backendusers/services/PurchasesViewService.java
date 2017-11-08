package com.shpetny.backendusers.services;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.models.ProductView;
import com.shpetny.backendusers.models.Purchases;
import com.shpetny.backendusers.models.PurchasesView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchasesViewService {

    @Autowired
    private ProductViewService productViewService;

    @Autowired
    private PurchasesService purchasesService;

    public List<PurchasesView> getPurchasesView(long userId){
        List<PurchasesView> purchasesViewList = new ArrayList<>();

        List<Purchases> purchasesList = purchasesService.getPurchasesByUserId(userId);
        List<Product> products = new ArrayList<>();
        for(Purchases purchases : purchasesList){
            products.addAll(purchases.getProducts());
        }
        List<ProductView> productViews = productViewService.buildingPriceView(products);




        return purchasesViewList;

    }
}
