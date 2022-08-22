/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

/**
 *
 * @author lucasspain
 */

import java.util.ArrayList;
import java.util.Scanner;

//class for Shop
public class Shop {
    private Cart cart;
    private ArrayList<Product> products;
    
    //default constructor for a shop - creates an ArrayList of products and a Cart object
    public Shop() {
        this.products = new ArrayList();
        this.cart = new Cart();
    }
    
    //method to start the online shop menu
    public void menu() {
        System.out.println("Welcome to the shop!");
        System.out.println("What would you like to do?");
        System.out.println("1.View all items\n2.Select Category\n3.Search\n4.View Cart\n5.Checkout\n");
        
    }
    
    //method to search for a product, returns an ArrayList of the products that were found
    public ArrayList<Product> search(String query) {
        
        ArrayList<Product> searchResult = new ArrayList<Product>();
        
        for (Product p : products)
        {
            if (p.search(query))
            {
                searchResult.add(p);
            }
        }
        
        return searchResult;
        
    }
    
    
    //method to get username input from user to log them in - need to add try catch here
    public User login() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter your username");
        String username = scan.nextLine();
        
        return new User(username);
       
    }
    
    //method to checkout
    public void checkout() {
        
    }
}
