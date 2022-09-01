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
import java.util.Scanner;

/**
 *
 * @author lucasspain
 */

//class for user login in the shop app, users are stored in a hashmap that is read from a file
public class User {
    
    //private instance variables for a user object
    private HashMap users;
    private String username;
    private int id;
    private FileIO fileio = new FileIO();
    
    private Scanner scan = new Scanner(System.in);
        
    
    //method to get username input from user to log them in - need to add try catch here
    public void login() {
        
        System.out.println("Please enter your username");
        String username = scan.nextLine();
        
        this.username = username;
       
    }
    
    
    //constructor method for a user, should check the file to see if the user already exists
    public User() {
        boolean exists = false;
        
        this.login();
        
        this.users = this.fileio.readUsers();
        
        Set eSet = users.entrySet();
        Iterator it = eSet.iterator();

        while (it.hasNext())
        {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            
            if (key.equalsIgnoreCase(this.username))
            {                  
                exists = true;
                this.id = (Integer)entry.getValue();
            }
            
        }
        
        if (exists == false)
        {
            this.id = users.size();
            users.put(this.username, users.size());
        }

  
}
    
    public int displayUser() {
        System.out.println("User Information:");
        System.out.println("Username: "+this.username+" User ID: "+this.id);

        
        boolean valid = true;
        
        int input = 0;
        
        do {
         
        System.out.println("\nWould you like to:\n1.Return to main menu\n2.Exit");
            
            valid = true;
            
            try {

                input = scan.nextInt();

                switch (input) {
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    default:
                        System.out.println("Invalid input");
                        valid = false;

                }
            } catch (Exception e)
            {
                System.out.println("Invalid input. Please try again.");
                scan.next();
            }   
        } while (input < 1 || input > 2 || valid == false);
        return 2;
        
        
    }
    
    public void save() {
        
        this.fileio.writeUsers(this.users);
    }

    
}
