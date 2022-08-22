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
 
        Shop shop1 = new Shop();
        
        Scanner scan = new Scanner(System.in);

        //get user to login
        User user1 = shop1.login();

        //display the menu for the shop
        shop1.mainMenu();
       
               
        //write the user to the text file
        user1.writeUsers();  
            
        }
        
}
    
