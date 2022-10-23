/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

/**
 *
 * @author lucasspain & Fahim
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//class for the shopping cart - used to keep track of the products the user will buy
public class Cart {
    
    private static Cart cartInstance;
    private Cart()
    { 
        this.inCart = new ArrayList();
        this.total = 0;
    }
    
    public static synchronized Cart getCartInstance()
    {
        if(cartInstance == null)
        {
            cartInstance = new  Cart();
        }
        return cartInstance;
    }
    
    //instance variables
    private ArrayList<Product> inCart;
    private float total;

    /**
     * @return the total
     */
    public float getTotal() {
        total = 0.0f;
        for (Product p : this.inCart) {
            this.setTotal((float) (total + p.getPrice()));
        }
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }
    
    //method to add a product to the cart
    public void add(Product p) {
        this.inCart.add(p);
    }

    //method to get the cart
    public ArrayList<Product> getInCart()
    {
        return inCart;
    }

    //method to remove a product from the cart
    public void remove(Product p) {
        this.inCart.remove(p);
    }
    
    
    public void remove(int index) {
        this.inCart.remove(index);
    }
    
    //prints out the contents of the cart ArrayList and the total price
    public String toString() {
        String output = "Cart contents:\n";
        
        if (this.inCart.size() == 0) {
            output += "Cart is empty";
        }
        else {

            for (Product p : this.inCart) {
                output += p.toString()+"\n";

                this.setTotal((float) (this.getTotal() + p.getPrice()));

            }
        }

        output += "\n\nTotal: $"+this.getTotal();
        this.setTotal(0);
        
        return output;
    }
}
