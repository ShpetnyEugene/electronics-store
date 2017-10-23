package com.shpetny.backendusers;

import com.shpetny.backendusers.models.Cart;
import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.persistance.CartRepository;
import com.shpetny.backendusers.persistance.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CartRepository repository;

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    //access command line arguments
    @Override
    public void run(String... args) throws Exception {

        Cart cart = new Cart();
        cart.setUserId(1);
        cart.setProducts(Arrays.asList(productRepository.findById(5)));
        repository.save(cart);
        //do something
    }

//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Application.class, args);
//    }
//
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").
                        allowedOrigins("http://localhost:8091",
                        "http://localhost:8092","http://localhost:8099","*","http://localhost:8091")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
            }
        };
    }
}