/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

import java.util.Scanner;

/**
 *
 * @author lucasspain
 */

//ShopApp class, has the main method
public class ShopApp {

    public static void main(String[] args) {
        
        //test
        Product p1 = new Test("Apple", "Tesla", 4.99); 
        Product p2 = new Test("Banana", "Tesla", 2.99);
        Product p3 = new Test("Banana", "Tesla", 2.99);
        Product p4 = new Test("Banana", "Tesla", 2.99);
        Product p5 = new Test("Banana", "Tesla", 2.99);
        Product p6 = new Test("Banana", "Tesla", 2.99);
        Product p7 = new Test("Banana", "Tesla", 2.99);
        Product p8 = new Test("Banana", "Tesla", 2.99);
        Product p9 = new Test("Banana", "Tesla", 2.99);
        Product p10 = new Test("Banana", "Tesla", 2.99);
        Product p11 = new Test("Banana", "Tesla", 2.99);
        Product p12 = new Test("Banana", "Tesla", 2.99);
        Product p13 = new Test("Banana", "Tesla", 2.99);
        Product p14 = new Test("Aapple", "Tesla", 2.99);


        Shop shop1 = new Shop();
        
        shop1.addProducts(p1);
        shop1.addProducts(p2);
        shop1.addProducts(p3);
        shop1.addProducts(p4);
        shop1.addProducts(p5);
        shop1.addProducts(p6);
        shop1.addProducts(p7);
        shop1.addProducts(p8);
        shop1.addProducts(p9);
        shop1.addProducts(p10);
        shop1.addProducts(p11);
        shop1.addProducts(p12);
        shop1.addProducts(p13);
        shop1.addProducts(p14);       
        
        
        Scanner scan = new Scanner(System.in);

        //get user to login
        User user1 = new User();

        //display the menu for the shop
        shop1.mainMenu();
       
        //write the user to the text file
        user1.writeUsers();  
         
        }
        
}
    
