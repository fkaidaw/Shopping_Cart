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
    
    private Scanner scan = new Scanner(System.in);

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
    private User user;
    
    //default constructor for a shop - creates an ArrayList of products and a Cart object
    public Shop() {
        this.products = new ArrayList();
        this.cart = new Cart();
        
        this.user = new User();
    }
    
    //method to start the online shop menu
    public void mainMenu() {
        
        int input = 0;
        boolean valid = true;
        
        do {

            System.out.println("\nWelcome to the shop!");
            System.out.println("What would you like to do?");
            System.out.println("1.View all items\n2.Select Category\n3.Search\n4.View Cart\n5.Checkout\n6.View Profile\n7.Exit");
            
            valid = true;
            
            try {

                input = scan.nextInt();
                
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
                        printProducts(search(searchInput));
                        break;
                    case 4:
                        viewCart();
                        break;
                    case 5:
                        checkout();
                        break;
                    case 6:
                        int next = this.user.displayUser();

                        if (next == 1)
                        {
                            this.mainMenu();
                        }
                        else
                        {
                            this.exit();
                        }

                        break;
                    case 7:
                        this.exit();
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }

            } catch (Exception e)
            {
                System.out.println("Invalid input. Please try again.");

                scan.next();
                valid = false;
            }
        } while ((input > 7 || input < 1) || valid == false);
        
    
    }
    
    //method to search for a product, returns an ArrayList of the products that were found
    public ArrayList<Product> search(String query) {
        
        ArrayList<Product> searchResult = new ArrayList<Product>();
        
        for (Product p : this.getProducts())
        {
            if (p.search(query))
            {
                searchResult.add(p);
            }
        }
        
        return searchResult;
        
    }

    
    //method to view the cart, user can either return to menu or continue to checkout from here
    public void viewCart() {
        System.out.println(this.cart);

        System.out.println("\nWould you like to:\n1.Return to main menu\n2.Checkout\n3.Exit");
        
        int input = 0;
        boolean valid = true;
        
        do {
            
            try {
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
                    this.exit();
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    break;

                }
            } catch (Exception e)
            {
                System.out.println("Invalid input. Please try again.");
                
                scan.next();
                valid = false;
            }

        } while (input < 1 || input > 3);
        
   
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
        
        if (size < 5 && size > 0) 
        {
            totalPages = 1;
        }
        else
        {
            totalPages = (size / 5);
            
            if ((size % 5) != 0 && size > 5)
            {
                totalPages += 1;
            }
        }
        

        while (cont) {
            
            if (size < 1)
            {
                currPage = 0;
            }
            
            System.out.println("Page "+currPage+" of "+totalPages+". "+size+" results.\n");

            if (totalPages > 0 && cont == true)
            {
                for (int i = 0; i < 5; i++) 
                {
                    if (itemNum < size)
                    {
                        itemNum = i + 1 + currItem;
                        System.out.println("Item Number: "+itemNum+" "+list.get(i + currItem));
                    }

                }
            }
            else
            {
                System.out.println("No results found.");
            }

            int input = 0;
            
            do {
                
                try {
                    
                    System.out.println("\nWould you like to:\n1.Purchase an item\n2.View next page\n3.View previous page\n4.Search\n5.Return to main menu\n6.Exit\n");


                    input = scan.nextInt();
                    scan.nextLine();

                    switch (input) {
                        case 1:
                            cont = false;

                            this.purchaseItem(list);
                            break;
                        case 2:
                            if (currPage != totalPages)
                            {
                                currPage += 1;
                                currItem += 5;

                            }
                            else
                            {
                                System.out.println("\nThere is no next page.");
                            }

                            itemNum -= 5;
                            
                            break;
                        case 3:
                            if (currPage > 1)
                            {
                                currPage -= 1;
                                currItem -= 5;

                            }
                            else
                            {
                                System.out.println("\nThere is no previous page.");
                            }
                            itemNum -= 5;

                            break;
                        case 4:
                            System.out.println("Search: ");
                            String searchInput = scan.nextLine();

                            cont = false;

                            printProducts(search(searchInput));

                            break;
                        case 5:
                            cont = false;
                            
                            this.mainMenu();
                            break;
                        case 6:

                            cont = false;
                            this.exit();

                            break;
                        default:
                            System.out.println("Invalid input, please try again");
                            break;
                    }
                } catch (Exception e)
                {
                    cont = true;
                    System.out.println("Invalid input. Please try again");
                    
                    scan.next();
                }

            } while ((input < 1 || input > 6) || cont == true);
            
        }
            
         
    }
    
    //method to add an item to the cart from the item list
    public void purchaseItem(ArrayList<Product> list) {
        
        int curr = 1;
        boolean found = false;
        boolean valid = true;
        
        int input = 0;
        
        try {
            
            valid = true;
                    
            System.out.println("Please enter the Item Number you would like to add to the cart");

            input = scan.nextInt();
            scan.nextLine();
            
        } catch (Exception e)
        {
            System.out.println("Invalid input. Please try again.");
            valid = false;
        }

        
        for (Product p : list)
        {
            if (curr == input)
            {
                this.cart.add(p);
                
                System.out.println(p.getName()+" has been added to the cart");
                
                found = true;
            }
            
            curr++;
        }
        
        if (found == false)
        {
            System.out.println("Item not found.");
        }
        
        this.printProducts(list);
        
    }
    
    //method to exit the program
    public void exit() {
        System.out.println("Exiting program");
        user.save();
    }
    
    //method to checkout the items currently in cart
    public void checkout() {
        
        System.out.println("\nthis is a test of the checkout method");

        
    }
    
}
