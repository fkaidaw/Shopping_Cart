/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

/**
 *
 * @author lucasspain & Fahim
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//Receipt class - will be used for writing the receipt to a text file
public class Receipt 
{
    // list of products
    ArrayList<Product> productsList = new ArrayList<Product>();
    
    private FileIO fileio = new FileIO();
    
    // function to print to text file 
    
// function to add to the list
    public void addProduct(Product newProduct)
    {
        productsList.add(newProduct);
    }
    
    // function to remove from the list
    public void removeProduct(Product product)
    {
        productsList.remove(product);
    }

    @Override
    public String toString()
    {
        String output = "Receipt: " + "\n";
        
        for(int i = 0; i < productsList.size(); i++)
        {
           output+= productsList.get(i)+"\n";
        }
        return output;
    }
    
    //print the receipt to a text file
    public void printToFile(String receipt)
    {
        fileio.printReceipt(receipt);
    }
    
    public void saveOrder(String username, String receipt) {
        fileio.saveUserOrder(username, receipt);
    }
}
