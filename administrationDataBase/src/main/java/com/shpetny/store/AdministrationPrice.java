package com.shpetny.store;


import com.shpetny.store.services.ConnectionDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

public class AdministrationPrice {

    private Connection connection = ConnectionDataBase.getConnection();
    private Scanner sc = new Scanner(System.in);

    public List<Price> getAllPrice(){
//        PreparedStatement statement = connection.prepareStatement();
        return null;
    }

    // TODO
    public boolean updatePriceOnId(int idPrice){
        return false;
    }


    // TODO
    public void menu(){
        int check = -1;

        do {
            System.out.println("1 - Show all prices");
            System.out.println("2 - Change price on ID");

           check =  sc.nextInt();

            switch (check){
                case 1:
                    getAllPrice();
                    break;
                case 2:

            }
        }while (check != 0);
    }
}
