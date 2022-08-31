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
 * @author fahim
 */
public class VegetableReader
{
     public ArrayList<Product> getVegetable()
    {
        ArrayList<Product> vegetableList = new ArrayList<Product>();
        
        String fileName = "";
	try
	{
            FileReader fr = new FileReader("./resources/Vegetable.txt");
            BufferedReader inputStream = new BufferedReader(fr);

            String line = null;
            line = inputStream.readLine();

            while(line != null)
            {
                String[] values = line.split(",", 3);
                String name = values[0];
                String manufacturer = values[1];
                double price = Double.parseDouble(values[2]);
                
                Vegetable vegetable = new Vegetable(name, manufacturer, price);
                vegetableList.add(vegetable);
                
                line = inputStream.readLine();
            }
            inputStream.close(); 
	}
	catch(FileNotFoundException e)
	{
            System.out.println("File not found.");
	}
	catch(IOException e)
	{
            System.out.println("Error reading from file" + fileName);
	}
        return vegetableList;
    }
}
