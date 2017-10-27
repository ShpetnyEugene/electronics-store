package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.*;
import com.shpetny.backendusers.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users/cart")
public class CartController {


    private final UserService userService;
    private final CartService cartService;


    @Autowired
    private PurchasesService purchasesService;

    @Autowired
    private ProductViewService service;
    @Autowired
    private ProductService productService;


    @Autowired
    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }


    @GetMapping
    public ProductView getProductById(@RequestParam("id") long id){
        Product product = productService.getProductById(id); // TODO
        return service.buildingPriceView((Arrays.asList(product))).get(0);
    }

    // TODO CHECK THIS
    @PostMapping
    public void addProduct(@RequestBody Product product, HttpSession session){
        long userId = (long) session.getAttribute("userId"); // TODO
        cartService.addProduct(product,userId);
    }

    @DeleteMapping
    public void buyAllProduct(HttpSession session){
        long userId = (long) session.getAttribute("userId"); // TODO
        User user = userService.getUserById(userId);
        List<Product> products = user.getCart().getProducts();
        productService.decrementAmountProducts(products);
        purchasesService.addNewPurchases(userId,products);
//        userService.deletePurchases(userId);
    }
}
