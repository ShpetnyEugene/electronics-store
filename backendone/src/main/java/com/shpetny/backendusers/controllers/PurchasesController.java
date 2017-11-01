package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.models.ProductView;
import com.shpetny.backendusers.models.Purchases;
import com.shpetny.backendusers.persistance.PurchasesRepository;
import com.shpetny.backendusers.services.ProductService;
import com.shpetny.backendusers.services.ProductViewService;
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
    private ProductService productService;

    @Autowired
    private ProductViewService productViewService;

    private final PurchasesService purchasesService;
    private final UserService userService;

    @Autowired
    public PurchasesController(PurchasesService purchasesService, UserService userService) {
        this.purchasesService = purchasesService;
        this.userService = userService;
    }

    @GetMapping
    public List<ProductView> getPurchases(HttpSession session) {// TODO
       List<Product> purchases = purchasesService.getProductByPurchases(1);

        return productViewService.buildingPriceView(purchasesService.getProductByPurchases((long)session.getAttribute("idUser")));
//        return purchasesService.getProductByPurchases((Long) session.getAttribute("idUser"));
    }


}
