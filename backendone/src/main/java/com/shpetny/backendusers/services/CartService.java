package com.shpetny.backendusers.services;

import com.shpetny.backendusers.models.Cart;
import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.models.User;
import com.shpetny.backendusers.persistance.CartRepository;
import com.shpetny.backendusers.persistance.ProductRepository;
import com.shpetny.backendusers.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public void addProduct (Product product,long userId){
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setProducts(Arrays.asList(productRepository.findById(product.getId())));
        cartRepository.save(cart);
    }
}
