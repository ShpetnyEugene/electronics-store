package com.shpetny.useriu.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MultipurposeController {

    @Value("app.backend.url")
    private String string;

    @GetMapping("/admin")
    public String showHomePage(ModelAndView modelAndView) {
//        modelAndView.addObject("adminUrl",string);
        return "home";
    }

    // Вход в систему
    @GetMapping("/users/login")
    public String showLoginPage() {
        return "login";
    }

    // Корзина покупок
    @GetMapping("/users/cart")
    public String showCartPage() {
        return "cart";
    }

    // Регистрация
    @GetMapping("/users/registration")
    public String showRegistrationPage() {
        return "registration";
    }

    // Список всех покупок
    @GetMapping("/products")
    public String showProductsPage() {
        return "products";
    }

    // Показать определенный продукт
    @GetMapping("/products/{productName}")
    public String showDefiniteProductsPage() {
        return "product";
    }

}
