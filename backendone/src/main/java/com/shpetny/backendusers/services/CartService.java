package com.shpetny.backendusers.services;

import com.shpetny.backendusers.models.Cart;
import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.models.Purchases;
import com.shpetny.backendusers.models.User;
import com.shpetny.backendusers.persistance.CartRepository;
import com.shpetny.backendusers.persistance.ProductRepository;
import com.shpetny.backendusers.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final PurchasesService purchasesService;
    private final ProductService service;
    private final UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    public CartService(CartRepository cartRepository, UserRepository userRepository, ProductRepository productRepository, PurchasesService purchasesService, ProductService service, UserService userService) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.purchasesService = purchasesService;
        this.service = service;
        this.userService = userService;
    }

    public void addProduct(Product product, long userId) {
        Cart cart = new Cart(userId);
        if (cart.getProducts() == null) {
            cart.setProducts(Arrays.asList(productRepository.findById(product.getId())));
        } else {
            cart.getProducts().add(productRepository.findById(product.getId()));
        }
        cartRepository.save(cart);
    }

    // TODO CHECK THIS
    public void buyAllProduct(long userId, List<Product> products) {
        User user = userService.getUserById(userId);
        Purchases purchases = new Purchases();
        purchases.setProducts(products);
        purchases.setDate(LocalDate.now());

        List<User> users = new ArrayList<>();
        users.add(user);

        List<Purchases> purchasesList = new ArrayList<>();
        purchasesList.add(purchases);


        purchases.setUsers(users);
        if (user.getPurchases() == null) {
            user.setPurchases(purchasesList);
        } else {
            user.getPurchases().add(purchases);
        }
        productService.decrementAmountProducts(products);
        userRepository.save(user);
        purchasesService.addNewPurchases(purchases);
    }


    public void deleteProductFromCart(long userId, Product product) {
        Product productInput = productService.getProductById(product.getId());
        Cart cart = userService.getUserById(userId).getCart();
        cart.getProducts().remove(productInput);
    }

}
