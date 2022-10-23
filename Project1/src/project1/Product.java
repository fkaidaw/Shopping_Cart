/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

/**
 *
 * @author lucasspain & Fahim
 */

//product is an abstract class - can be extended into different categories of products that will be listed on the store
public abstract class Product implements Comparable<Product>{
    
    //encapsulated instance varaiables for a Product object
    private String name;
    private String manufacturer;
    private double price;
    private int stock;
    
    //get and set methods for instance variables

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
        /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param price the price to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    //method to check if a query matches the name or manufacturer of a product
    public boolean search(String query) {
        
        if (this.name.toLowerCase().contains(query.toLowerCase())) {
            return true;
        }
        else if (this.manufacturer.toLowerCase().contains(query.toLowerCase())) {
            return true;
        }
        else {
            return false;
        }
    }
            
    //toString method, prints out name, manufacturer, and price
    public String toString() {
        String output = this.name + " Manufacturer: "+this.manufacturer + " Price: $"+this.price;
        
        return output;
    }
    //override for comparing products 
    @Override
    public int compareTo(Product p) {
        return this.getName().compareTo(p.getName());
    }
    
    
}
