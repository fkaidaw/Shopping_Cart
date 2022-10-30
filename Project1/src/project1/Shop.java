/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

/**
 *
 * @author lucasspain & Fahim
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
    
    //add products to the shop
    public void addProducts(Product p) {
        this.products.add(p);
    }
    
    private Cart cart;
    private ArrayList<Product> products;
    private User user;
    
    //default constructor for a shop - creates an ArrayList of products and a Cart object
    public Shop() {
        this.products = new ArrayList();
        //this.cart = new Cart();
       
    }

}