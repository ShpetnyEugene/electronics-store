package com.shpetny.store;

import com.shpetny.store.menus.MenuSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        new MenuSecurity().showMenu();
    }
}
