/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author lucasspain & Fahim
 */
public class Reader {
    private static Database readerDB = Database.getDatabaseInstance();
    
    public static void insertData(String name, String manufacturer, String category, double price) {
        readerDB.insertProduct(name, manufacturer, category, price);
    }
    
    public static ArrayList<Product> getCategory(String Category) {
        ArrayList<Product> list = new ArrayList<Product>();
        
        ResultSet rs = readerDB.getCategory(Category);
        
        String name;
        String manufacturer;
        double price;
        
        try {
                    
            while (rs.next()) {
                name = rs.getString(1);
                manufacturer = rs.getString(2);
                price = rs.getDouble(4);

                if (Category == "Meat")
                {
                    list.add(new Meat(name, manufacturer, price));
                }
                else if (Category == "Vegetable")
                {
                    list.add(new Vegetable(name, manufacturer, price));
                }
                else if (Category == "Fruit")
                {
                    list.add(new Fruit(name, manufacturer, price));
                }
            }
        }
        catch (SQLException e) 
        {
            System.out.println("SQLException: "+ e);
        }
        
        return list;

    }
}
