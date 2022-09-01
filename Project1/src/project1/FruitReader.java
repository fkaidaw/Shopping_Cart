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
// file reader for fruit 
public class FruitReader
{
    //gets fruit from the fruit file
     public ArrayList<Product> getFruit()
    {
        ArrayList<Product> fruitList = new ArrayList<Product>();
        
        String fileName = "./resources/Fruit.txt";
        FileIO fileIO = new FileIO();
        ArrayList<String> fileLines = fileIO.readFile(fileName);
        
        for (int i = 0; i < fileLines.size(); i++)
        {
            String[] values = fileLines.get(i).split(",", 3);
            String name = values[0];
            String manufacturer = values[1];
            double price = Double.parseDouble(values[2]);

            Fruit fruit = new Fruit(name, manufacturer, price);
            fruitList.add(fruit);
        }
        return fruitList;
    }
}
