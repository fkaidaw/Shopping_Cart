/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

import java.util.Observable;

/**
 *
 * @author fahim
 */
public class HomeModel extends Observable
{
    public Database db;
    public Data data;
    
    public HomeModel()
    {
        this.db = new Database();
        this.db.dbsetup();
    }
    
    public void quitGame()
    {
        System.exit(0);
    }
    
    public void viewAllItems()
    {
        System.out.println("View all item");
    }
    
    public void viewCart()
    {
        System.out.println("View cart");
    }
    
    public void viewProfile()
    {
        System.out.println("View profile");
    }
}
