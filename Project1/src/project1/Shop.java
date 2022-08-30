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
import java.util.Collections;
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
    
    public void addProducts(Product p) {
        this.products.add(p);
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
        System.out.println("\nWelcome to the shop!");
        System.out.println("What would you like to do?");
        System.out.println("1.View all items\n2.Select Category\n3.Search\n4.View Cart\n5.Checkout\n");
        
        Scanner scan = new Scanner(System.in);
        
        int input = scan.nextInt();
        
        switch (input) {
            case 1:
                printProducts(this.products);
                break;
            case 2:
                break;
            case 3:
                System.out.println("Search: ");
                
                scan.nextLine();
                
                String searchInput = scan.nextLine();
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
        
        for (Product p : this.getProducts())
        {
            if (p.search(query))
            {
                searchResult.add(p);
                System.out.println(p);
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

        System.out.println("\nWould you like to:\n1.Return to main menu\n2.Checkout\n3.Exit");
        
        Scanner scan = new Scanner(System.in);
        
        int input;
        
        do {
        input = scan.nextInt();
        scan.nextLine();
        
        switch (input) {
            case 1:
                this.mainMenu();
                break;
            case 2:
                this.checkout();
                break;
            case 3:
                System.out.println("Exiting program");
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
                
            }
        } while (input < 1 || input > 3);
        
   
    }
    
    //method to checkout
    public void checkout() {
        
        System.out.println("\nthis is a test of the checkout method");

        
    }
    
    //method to print products in an arraylist in pages of 5 items, sorted alphabetically
    public void printProducts(ArrayList<Product> list) {
        
        Collections.sort(list);
        
        int currPage = 1; 
        int size = list.size();
        int totalPages;
        int currItem = 0;
        boolean cont = true;
        int itemNum = 0;
        
        if (size < 5) 
        {
            totalPages = 1;
        }
        else
        {
            totalPages = (size / 5);
            
            if ((size % 5) != 0)
            {
                totalPages += 1;
            }
        }
        
        Scanner scan = new Scanner(System.in);
        
        
        
        while (cont == true) {
            
            System.out.println("Page "+currPage+" of "+totalPages+". "+size+" results.\n");

            for (int i = 0; i < 5; i++) 
            {
                if (itemNum < size)
                {
                    itemNum = i + 1 + currItem;
                    System.out.println("Item Number: "+itemNum+" "+list.get(i + currItem));
                }

            }
            
            int input = 0;
            
            do {
                System.out.println("\nWould you like to:\n1.Purchase an item\n2.View next page\n3.View previous page\n4.Return to main menu\n5.Exit");

                
                input = scan.nextInt();
                scan.nextLine();

                switch (input) {
                    case 1:
                        break;
                    case 2:
                        if (currPage != totalPages)
                        {
                            currPage += 1;
                            currItem += 5;
                            itemNum -= 5;
                        }
                        break;
                    case 3:
                        if (currPage != 1)
                        {
                            currPage -= 1;
                            currItem -= 5;
                            itemNum -= 5;
                        }

                        break;
                    case 4:
                        cont = false;

                        this.mainMenu();
                        break;
                    case 5:
                        System.out.println("Exiting program");

                        cont = false;
                        break;
                    default:
                        System.out.println("Invalid input, please try again");
                        break;
                }
            } while (input < 1 || input > 5);
            
        }
            
         
    }
}
