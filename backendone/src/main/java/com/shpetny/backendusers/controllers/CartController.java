package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/users/cart")
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    // TODO CHECK THIS
    @PostMapping
    public void addProduct(@RequestBody Product product, HttpSession session){
        long userId = (long) session.getAttribute("user"); // TODO
        cartService.addProduct(product,userId);
    }
}
