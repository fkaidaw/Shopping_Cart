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

    /**
     * @return the cart
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    /**
     * @return the products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    private Cart cart;
    private ArrayList<Product> products;
    
    //default constructor for a shop - creates an ArrayList of products and a Cart object
    public Shop() {
        this.products = new ArrayList();
        this.cart = new Cart();
    }
    
    //method to start the online shop menu
    public void mainMenu() {
        System.out.println("Welcome to the shop!");
        System.out.println("What would you like to do?");
        System.out.println("1.View all items\n2.Select Category\n3.Search\n4.View Cart\n5.Checkout\n");
        
        Scanner scan = new Scanner(System.in);
        
        int input = scan.nextInt();
        
        switch (input) {
            case 1:
                displayProducts();
                break;
            case 2:
                break;
            case 3:
                System.out.println("Search: ");
                
                String searchInput;
                searchInput = scan.nextLine();
                search(searchInput);
                break;
            case 4:
                viewCart();
                break;
            case 5:
                checkout();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
        
    }
    
    //method to search for a product, returns an ArrayList of the products that were found
    public ArrayList<Product> search(String query) {
        
        ArrayList<Product> searchResult = new ArrayList<Product>();
        
        for (Product p : getProducts())
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
    
    public void displayProducts() {
        for (Product p : getProducts())
        {
            System.out.println(p);
        }
    }
    
    //method to view the cart, user can either return to menu or continue to checkout from here
    public void viewCart() {
        System.out.println(this.cart);

        System.out.println("\n\nWould you like to:\n1.Return to main menu\n2.Checkout");
        
        
    }
    
    //method to checkout
    public void checkout() {

        
    }
}
