package com.shpetny.backendusers.services;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.models.Purchases;
import com.shpetny.backendusers.models.User;
import com.shpetny.backendusers.persistance.PurchasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PurchasesService {

    private final PurchasesRepository purchasesRepository;
    private final UserService userService;

    @Autowired
    public PurchasesService(PurchasesRepository purchasesRepository, UserService userService) {
        this.purchasesRepository = purchasesRepository;
        this.userService = userService;
    }


    public List<Product> getProductByPurchases(long idUser){
        User user = userService.getUserById(idUser);
        List<Product> products = new ArrayList<>();
        for(Purchases purchases: user.getPurchases()) {
            products.addAll(purchases.getProducts());
        }
        return products;
    }


    public void addNewPurchases(Purchases purchases){
        purchasesRepository.save(purchases);

    }
}
