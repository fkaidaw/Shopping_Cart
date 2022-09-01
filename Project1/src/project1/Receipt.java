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

    // print the list to text file 
    public void printToFile(Receipt receipt)
    {
	PrintWriter pw = null;
	try
	{
            pw = new PrintWriter(new FileOutputStream("./resources/Receipt.txt"));
            pw.println(receipt);
            System.out.println("... written to out.txt.");
            pw.close();
	} 
	catch(FileNotFoundException e)
	{	
            System.out.println(e.getMessage());
	}
    }
      // print the list to text file 
    public void printToFile(String receipt)
    {
	PrintWriter pw = null;
	try
	{
            pw = new PrintWriter(new FileOutputStream("./resources/Receipt.txt"));
            pw.println(receipt);
            System.out.println("... written to out.txt.");
            pw.close();
	} 
	catch(FileNotFoundException e)
	{	
            System.out.println(e.getMessage());
	}
    }
}
