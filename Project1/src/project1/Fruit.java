/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

/**
 *
 * @author lucasspain & Fahim
 */
//Creating fruit objects
public class Fruit extends Product
{
    public Fruit(String name, String manufacturer, double price)
    {
        this.setName(name);
        this.setManufacturer(manufacturer);
        this.setPrice(price);
        this.setCategory("Fruit");
    }
}
