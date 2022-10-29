/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author lucasspain & Fahim 
 */
// file reader for meat 
public class MeatReader
{
    public MeatReader(){
        insertMeat();
    }
    
    //gets vegetables from vegetable file and puts into database
     public void insertMeat()
    {
        String fileName = "./resources/Meat.txt";
        
        FileIO fileIO = new FileIO();
        ArrayList<String> fileLines = fileIO.readFile(fileName);
        
        for (int i = 0; i < fileLines.size(); i++)
        {
            String[] values = fileLines.get(i).split(",", 3);
            String name = values[0];
            String manufacturer = values[1];
            double price = Double.parseDouble(values[2]);

            Reader.insertData(name, manufacturer, "Meat", price);
        }
    }
     
    //gets meat from product database
     public ArrayList<Product> getMeats()
    {
        ArrayList<Product> meatList = Reader.getCategory("Meat");
        return meatList;
    }
     
}
