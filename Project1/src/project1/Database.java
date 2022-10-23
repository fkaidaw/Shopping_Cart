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
    private Database()
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
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(12), password VARCHAR(12), score INT)");
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
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, password, score FROM UserInfo "
                    + "WHERE userid = '" + username + "'");
            if (rs.next())
            {
                String pass = rs.getString("password");
                System.out.println("***" + pass);
                System.out.println("found user");

                if (password.compareTo(pass) == 0) 
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
                System.out.println("no such user");
                statement.executeUpdate("INSERT INTO UserInfo "
                        + "VALUES('" + username + "','" + password + "', 0)");
                data.loginFlag = true;
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    private boolean checkTableExisting(String newTableName)
    {
        boolean flag = false;
        try
        {
            System.out.println("check existing tables... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);
        
            while (rsDBMeta.next())
            {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) 
                {
                     System.out.println(tableName + " is there");
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

        }
        return flag;
    }
    public void quitGame(int score, String username)
    {
        Statement statement;
        try
        {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE UserInfo SET score=" + score + " WHERE userid ='" + username + "'");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}