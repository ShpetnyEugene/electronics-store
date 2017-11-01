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
    private final PurchasesService purchasesService;
    private final ProductViewService service;
    private final ProductService productService;

    @Autowired
    public CartController(CartService cartService, UserService userService, PurchasesService purchasesService, ProductViewService service, ProductService productService) {
        this.cartService = cartService;
        this.userService = userService;
        this.purchasesService = purchasesService;
        this.service = service;
        this.productService = productService;
    }

    @GetMapping
    public ProductView getProductById(@RequestParam("id") long id){
        Product product = productService.getProductById(id);
        return service.buildingPriceView((Arrays.asList(product))).get(0);
    }

    // TODO CHECK THIS
    @PostMapping
    public void addProduct(@RequestBody Product product, HttpSession session){
        if(session.getAttribute("userId") != null){
            long userId = (long) session.getAttribute("userId"); // TODO
            cartService.addProduct(product,userId);
        }
    }

    @PutMapping
    public void buyAllProduct(HttpSession session,@RequestBody List<Product> products ){
        if(session.getAttribute("userId") != null){
            long userId = (long) session.getAttribute("userId"); // TODO
            cartService.buyAllProduct(userId,products);
        }else{
            productService.decrementAmountProducts(products);
        }
    }

    @DeleteMapping
    public void deleteProductFromCart(@RequestBody Product product,HttpSession session){
        if(session.getAttribute("userId") != null){
            long userId = (long) session.getAttribute("userId"); // TODO
            cartService.deleteProductFromCart(userId,product);
        }
    }
}
