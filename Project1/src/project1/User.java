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
 * @author lucasspain & Fahim
 */

//class for user login in the shop app, users are stored in a hashmap that is read from a file
public class User {

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
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
        
        this.setUsername(username);
       
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
    
    
    //method to get the users last order
    public void getLastOrder() {
        this.fileio.userLastOrder(this.getUsername());
    }
    
    //method to save the program users to a text file
    public void save() {
        
        this.fileio.writeUsers(this.users);
    }

    
}
