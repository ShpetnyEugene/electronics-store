package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.models.ProductView;
import com.shpetny.backendusers.services.CartService;
import com.shpetny.backendusers.services.ProductService;
import com.shpetny.backendusers.services.ProductViewService;
import com.shpetny.backendusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users/cart")
public class CartController {

    private final UserService userService;
    private final CartService cartService;
    private final ProductViewService service;
    private final ProductService productService;

    @Autowired
    public CartController(CartService cartService, UserService userService, ProductViewService service, ProductService productService) {
        this.cartService = cartService;
        this.userService = userService;
        this.service = service;
        this.productService = productService;
    }

    @GetMapping
    public ProductView getProductById(@RequestParam("id") long id) {
        Product product = productService.getProductById(id);
        return service.buildingPriceView((Arrays.asList(product))).get(0);
    }

    public void addProduct(@RequestBody Product product, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            long userId = (long) session.getAttribute("userId");
            cartService.addProduct(product, userId);
        }
    }

    @PutMapping
    public void buyAllProduct(HttpSession session, @RequestBody List<Long> products) {
        List<Product> products1 = new ArrayList<>();
        for (Long lo : products) {
            products1.add(productService.getProductById(lo));
        }
        if (session.getAttribute("userId") != null) {
            long userId = (long) session.getAttribute("userId");
            cartService.buyAllProduct(userId, products1);
        } else {
            productService.decrementAmountProducts(products1);
        }
    }

    @DeleteMapping
    public void deleteProductFromCart(@RequestBody Product product, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            long userId = (long) session.getAttribute("userId");
            cartService.deleteProductFromCart(userId, product);
        }
    }
}
