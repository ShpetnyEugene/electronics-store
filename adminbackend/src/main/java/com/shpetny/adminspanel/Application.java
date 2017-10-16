package com.shpetny.adminspanel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan("com.shpetny.backendusers.persistance")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
