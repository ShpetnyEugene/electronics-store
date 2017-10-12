package com.shpetny.store.menus;

import org.springframework.beans.factory.annotation.Value;

import java.util.Scanner;

public class MenuSecurity {

    @Value("${app.admin.login}")
    private String loginAdmin;

    @Value("${app.admin.password}")
    private String passwordAdmin;

    private Menu menu = new Menu();
    private Scanner sc = new Scanner(System.in);


    public void showMenu() {
        while (true) {
            System.out.println("Must enter a username and password");
            if (loginAdmin.equals(sc.nextLine()) && passwordAdmin.equals(sc.next())) {
                break;
            }
            menu.showMenu();
        }
    }
}
