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
        shop1.menu();
        
        int input = scan.nextInt();
        
        switch (input) {
            case 1:
                shop1.displayProducts();
                break;
            case 2:
                break;
            case 3:
                System.out.println("Search: ");
                
                String searchInput;
                searchInput = scan.nextLine();
                shop1.search(searchInput);
                break;
            case 4:
                System.out.println(shop1.getCart());
                break;
            case 5:
                shop1.checkout();
                break;
            default:
                System.out.println("Invalid input");
                break;
                
            
        }

                    

        //write the user to the text file
        user1.writeUsers(); 

        
    }
    
}
