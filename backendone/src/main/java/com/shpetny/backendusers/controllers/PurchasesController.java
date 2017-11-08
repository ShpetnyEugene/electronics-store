package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Purchases;
import com.shpetny.backendusers.services.ProductService;
import com.shpetny.backendusers.services.ProductViewService;
import com.shpetny.backendusers.services.PurchasesService;
import com.shpetny.backendusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @PostMapping
    @ResponseBody
    public List<Purchases> getPurchases(HttpSession session) {
        if (session.getAttribute("userId") != null) {
            long id = (long) session.getAttribute("userId");
            return purchasesService.getPurchasesByUserId(id);
        } else {
            return null;
        }
    }


}
