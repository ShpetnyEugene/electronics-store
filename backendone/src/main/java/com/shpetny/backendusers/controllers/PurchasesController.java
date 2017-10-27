package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.models.Purchases;
import com.shpetny.backendusers.persistance.PurchasesRepository;
import com.shpetny.backendusers.services.PurchasesService;
import com.shpetny.backendusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users/purchases")
public class PurchasesController {

    @Autowired
    private PurchasesService purchasesService;

    @Autowired
    private UserService userService;


    @GetMapping
    public List<Product> getPurchases(HttpSession session) {// TODO
        return purchasesService.getProductByPurchases((Long) session.getAttribute("idUser"));
    }


}
