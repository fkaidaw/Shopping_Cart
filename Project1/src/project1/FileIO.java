/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author lucasspain
 */

//Central FileIO class, contains all read and write methods to files
public class FileIO {
    
        //method to read the users from a text file into a hashmap
    public HashMap readUsers() {
        
        HashMap users = new HashMap();
        
        try {
            FileReader fr = new FileReader("./resources/shop_users.txt"); 
            BufferedReader inputStream = new BufferedReader(fr);

            String line = null;

            while ((line=inputStream.readLine())!=null)
            {
                String[] split = line.split(" ");

                String name = split[0].trim();
                int value = Integer.parseInt(split[1].trim());

                users.put(name, value);
            }
                
                Set eSet = users.entrySet();
                Iterator it = eSet.iterator();
                
                while (it.hasNext())
                {
                    Map.Entry entry = (Map.Entry) it.next();
                    String key = (String) entry.getKey();
                }

            
            inputStream.close();
   
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Error reading from file");
        }
        
        return users;
            
    }

    //method to write users in the hashmap to a text file
    public void writeUsers(HashMap users) {
        
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new FileOutputStream("./resources/shop_users.txt"));

            Set eSet = users.entrySet();
            Iterator it = eSet.iterator();
            
            
            while (it.hasNext())
            {
                Map.Entry entry = (Map.Entry) it.next();
                
                String key = (String) entry.getKey();
                Integer value = (Integer) entry.getValue();
                
                pw.write(key+" "+value);
                pw.write("\n");

            }
            
            pw.close();

        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
