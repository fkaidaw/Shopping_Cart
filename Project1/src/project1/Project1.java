/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author fahim
 */
public class Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       Receipt receipt = new Receipt();
       Test test1 = new Test("Apple", "Tesla", 4.99); 
       Test test2 = new Test("Banana", "Tesla", 2.99);
       
       receipt.addProduct(test1);
       receipt.addProduct(test2);
       
       System.out.println(receipt);
       receipt.printToFile(receipt);
    }
   

}
