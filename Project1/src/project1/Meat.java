package project1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lucasspain & Fahim
 */
//Creating meat objects 
public class Meat extends Product
{
    private double weight = 0.00;
    
    public Meat(String name, String manufacturer, double price)
    {
        this.setName(name);
        this.setManufacturer(manufacturer);
        this.setPrice(price);
    }
}
