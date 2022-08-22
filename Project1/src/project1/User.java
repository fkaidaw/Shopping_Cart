/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

import java.util.HashMap;

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
    
    //if user has enough points give discount ?
    
}
