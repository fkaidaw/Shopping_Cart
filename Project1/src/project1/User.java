/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author lucasspain
 */

//class for user login in the shop app, users are stored in a hashmap that is read from a file
public class User {
    
    //private instance variables for a user object
    private HashMap users;
    private String username;
    private int points;
    
    //constructor method for a user, should check the file to see if the user already exists
    public User(String username) {
        this.username = username;
        this.points = 0;
        
        this.readUsers();
  
}
    //method to read the users from a text file into a hashmap
    public void readUsers() {
        
        this.users = new HashMap();
        
        try {
            FileReader fr = new FileReader("./resources/shop_users.txt"); 
            BufferedReader inputStream = new BufferedReader(fr);

            String line = null;

            while ((line=inputStream.readLine())!=null)
            {
                String[] split = line.split(" ");

                String name = split[0].trim();
                int score = Integer.parseInt(split[1].trim());

                users.put(name, score);
            }
                
                Set eSet = users.entrySet();
                Iterator it = eSet.iterator();
                
                while (it.hasNext())
                {
                    Map.Entry entry = (Map.Entry) it.next();
                    String key = (String) entry.getKey();


                    if (this.username.equals(key))
                    {
                        this.points = (Integer)entry.getValue();
                    }
                }

            
            inputStream.close();
   
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Error reading from file");
        }
            
    }
    // Talk to Lucas about removing the below code
    //method to write users in the hashmap to a text file
    public void writeUsers() {
        
        users.put(this.username, this.points);
        
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
    
    public boolean Discount() {
        if (this.points >= 100)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void decreasePoints(int p) {
        this.points -= p;
    }
    
    public void increasePoints(int p) {
        this.points += p;
    }
    
    //if user has enough points give discount ?
    
}
