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
    
    //method to get the users last order
    public void getLastOrder() {
        this.fileio.userLastOrder(this.getUsername());
    }
    
    //method to save the program users to a text file
    public void save() {
        
        this.fileio.writeUsers(this.users);
    }

    
}
