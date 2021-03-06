package com.shpetny.store.menus;

import com.shpetny.store.services.PriceService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class Menu {

    private static final Logger log = Logger.getLogger(Menu.class);

    private PriceService service = new PriceService();

    public void showMenu() {
        int item = -1;
        int id = 0;
        int newValue;
        while (item != 0) {
            System.out.println("Select the menu item:");
            System.out.println("1 - Show all Prices");
            System.out.println("2 - Update prices by ID");
            System.out.println("0 - Exit");

            item = selectInt();

            switch (item) {
                case 1:
                    id = 0;
                    service.printPrices(service.getPrice(id));
                    log.info("All prices are received");
                    break;
                case 2:
                    System.out.println("Enter id: ");
                    id = selectInt();
                    System.out.println("Enter new Value: ");
                    newValue = selectInt();
                    service.updatePrice(id,newValue);
                    log.info("Update price with id : " + id);
                    break;
                case 0:
                    item = 0;
                    break;
            }
        }
    }

    private int selectInt() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return 0;
    }
}
