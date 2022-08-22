/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

/**
 *
 * @author lucasspain
 */

//ShopApp class, has the main method
public class ShopApp {

    public static void main(String[] args) {
        
        //need a method to check and update this
        boolean exit = false;
        
        while (exit == false)
        {
            //create a shop and cart object
            Shop shop1 = new Shop();
            Cart cart = new Cart();

            //get user to login
            User user1 = shop1.login();

            //display the menu for the shop
            shop1.menu();

            //write the user to the text file
            user1.writeUsers(); 
        }
        
    }
    
}
