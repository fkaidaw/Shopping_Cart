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

//class for the shopping cart - used to keep track of the products the user will buy
public class Cart {
    //instance variables
    private ArrayList<Product> inCart;
    private int total;
    
    //default constructor, creates an Arraylist of products and sets total price to 0
    public Cart() {
        this.inCart = new ArrayList();
        this.total = 0;
    }
    
    //method to add a product to the cart
    public void add(Product p) {
        this.inCart.add(p);
    }
    
    //method to remove a product from the cart
    public void remove(Product p) {
        this.inCart.remove(p);
    }
    
    //prints out the contents of the cart ArrayList and the total price
    public String toString() {
        String output = "Cart contents:\n";
        
        for (Product p : inCart) {
            output += p.toString();
            
            this.total += p.getPrice();
            
        }
        
        
        output += "\n\nTotal: $"+this.total;
        
        return output;
        
    }
    
    
}
