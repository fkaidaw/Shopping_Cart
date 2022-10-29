/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fahim
 */
public class Database
{
    Connection conn = null;
    String url = "jdbc:derby:ShoppingListTestDB;create=true";
    
    String dbusername = "pdc";
    String dbpassword = "pdc";
    
    private static Database databaseInstance;
    public Database()
    { 
      
    }
    
    public static synchronized Database getDatabaseInstance()
    {
        if(databaseInstance == null)
        {
            databaseInstance = new  Database();
        }
        return databaseInstance;
    }
    
    public void dbsetup()
    {
        try
        {
            conn = DriverManager.getConnection("jdbc:derby:ShoppingListTestDB;create=true", "pdc", "pdc");  
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";

            if (!checkTableExisting(tableName)) 
            {
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid INT, username VARCHAR(12), password VARCHAR(12))");
            }
            
            tableName = "Products";

            if (!checkTableExisting(tableName)) 
            {
                statement.executeUpdate("CREATE TABLE " + tableName + " (itemid INT, name VARCHAR(50), manufacturer VARCHAR(50), category VARCHAR(50), price FLOAT)");
            }
            statement.close();
        }
        catch (Throwable e)
        {
            
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public Data checkName(String username, String password)
    {
        Data data = new Data();
        try
        {
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery("SELECT userid, password FROM UserInfo "
                    + "WHERE username = '" + username + "'");
            if (rs.next())
            {
                String pass = rs.getString("password");
                System.out.println(username + "***");
                System.out.println("found user");

                if (password.equals(pass)) 
                {
                   data.loginFlag = true;
                }
                else 
                {
                    data.loginFlag = false;
                }
            }
            else
            {
                int currID = 0;
                rs = statement.executeQuery("SELECT * FROM UserInfo");
                
                rs.beforeFirst();
                if (rs.next())
                {
                    rs.last();
                    
                    currID = rs.getInt("userid") + 1; 
                    
                }
                
                rs.beforeFirst();
                
                System.out.println("no such user");
                statement.executeUpdate("INSERT INTO UserInfo "
                        + "VALUES(" + currID + ", '" + username + "','" + password + "')");
                data.loginFlag = true;
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public boolean checkTableExisting(String newTableName)
    {
        boolean flag = false;
        try
        {
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);
        
            while (rsDBMeta.next())
            {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) 
                {
                     flag = true;
                }
            }
            if (rsDBMeta != null) 
            {
                rsDBMeta.close();
            }
        }
        catch (SQLException ex)
        {
            System.out.println("SQLException: "+ex);
        }
        return flag;
    }
    
    //insert products into the product table
    public void insertProduct(String name, String manufacturer, String category, double price)
    {
        dbsetup();
        
        int currID = 0;
        boolean exists = false;
        
        try {
        
            ResultSet rs = null;
            
             if (conn == null)
             {
                conn = DriverManager.getConnection("jdbc:derby:ShoppingListTestDB;create=true", "pdc", "pdc");  
             }

            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT * FROM Products");

            if (rs.next() == false)
            {
                currID = 1;
            }
            else
            {
                rs.last();
                currID = rs.getInt("itemid") + 1;
                
                rs.beforeFirst();
                while (rs.next())
                {
                    if (rs.getString("name").equalsIgnoreCase(name))
                    {
                        exists = true;
                    }
                }
            }

            statement.close();

        } 
        catch (SQLException e)
        {
            System.out.println("SQLException: "+e);
        }
        
        if (!exists)
        {
                   
            try {
                Statement statement = conn.createStatement();       
                statement.executeUpdate("INSERT INTO Products "
                            + "VALUES(" + currID + ",'" + name + "','" + manufacturer + "','" + category + "'," + price+")");
            }
            catch (SQLException e)
            {
                System.out.println("SQLException: "+e); 
            }
 
        }

    }
    
    
    public ResultSet getCategory(String category) {
        
        ResultSet rs = null;
        
        try {
            Statement statement = conn.createStatement();
            rs = statement.executeQuery("SELECT name, manufacturer, category, price FROM Products WHERE CATEGORY = '"+category+"'");

        }
        catch (SQLException e)
        {
            System.out.println("SQL Exception: "+ e);
        }
        
                    
        return rs;
    }
    
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}