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

//Central FileIO class, contains all read and write methods to files
public class FileIO {
    
    public ArrayList<String> readFile(String fileName)
    {
        ArrayList<String> linesList = new ArrayList<String>();
        String line = null;
        
	try
	{
            FileReader fr = new FileReader(fileName);
            BufferedReader inputStream = new BufferedReader(fr);

            line = inputStream.readLine();
            
            while(line != null)
            {
                linesList.add(line);
                line += inputStream.readLine();
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
        return linesList;
    }
}
