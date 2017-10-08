package com.shpetny.store;

import java.util.Scanner;

public class Menu {

    public void showMenu(int a) {
        a = -1;
        while (a != 0) {
            System.out.println("Select the menu item:");
            System.out.println("1 - Show all Prices");
            System.out.println("2 - Update prices by ID");
            System.out.println("0 - Exit");

            switch (a) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    a = 0;
                    break;
            }
        }
    }

    public int selectItem() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return 0;
    }
}
