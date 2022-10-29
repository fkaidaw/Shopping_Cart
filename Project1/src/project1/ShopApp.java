/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lucasspain & Fahim
 */
//ShopApp class, has the main method
public class ShopApp {

    public static void main(String[] args) {

        ArrayList<Product> productList = new ArrayList<Product>();

        MeatReader meatReader = new MeatReader();
        ArrayList<Product> meatList = meatReader.getMeats();
        productList.addAll(meatList);

        FruitReader fruitReader = new FruitReader();
        ArrayList<Product> fruitList = fruitReader.getFruit();
        productList.addAll(fruitList);

        VegetableReader vegetableReader = new VegetableReader();
        ArrayList<Product> vegetableList = vegetableReader.getVegetable();
        productList.addAll(vegetableList);

        Shop shop1 = new Shop();

        for (int i = 0; i < productList.size(); i++) {
            shop1.addProducts(productList.get(i));
        }

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        LoginModel loginModel = new LoginModel();
        LoginController loginController = new LoginController(loginScreen, loginModel);
    
//        //display the menu for the shop
//        shop1.mainMenu();

    }
}
