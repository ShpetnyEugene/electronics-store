package com.shpetny.store.menus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Component
@PropertySource("classpath:application.properties")
public class MenuSecurity {

    @Value("${app.admin.login}")
    private String loginAdmin;

    @Value("${app.admin.password}")
    private String passwordAdmin;

    private Menu menu = new Menu();
    private Scanner sc = new Scanner(System.in);


    @PostConstruct
    public void showMenu() {
        while (true) {
            System.out.println("Must enter a username:");
            String inputLogin = sc.nextLine();
            System.out.println("Must enter a password:");
            String inputPassword = sc.nextLine();
            if (loginAdmin.equals(inputLogin) && passwordAdmin.equals(inputPassword)) {
                System.out.println("Successful !!!");
                break;
            }
            System.out.println("Please repeat !");
        }
        menu.showMenu();
    }
}
