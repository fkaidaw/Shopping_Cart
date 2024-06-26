/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

import java.util.Observable;
import java.util.Random;

/**
 *
 * @author fahim & lucasspain
 */
public class LoginModel extends Observable
{
    public Database db;
    public Data data;
    public int answer = 0;
    public String username;
    
    //default constructor for LoginModel
    public LoginModel()
    {
        this.db = Database.getDatabaseInstance();
    }

    //method to check the name a user has entrered and log them in if password matches
    public void checkName(String username, String password)
    {
        this.username = username;
        this.data = this.db.checkName(username, password);
        this.db.dbusername = username;
        this.db.dbpassword = password;
        
        this.setChanged();
        this.notifyObservers(this.data);
        
        if (this.data.loginFlag == true)
        {
            HomeScreen homeview = new HomeScreen();
            homeview.setVisible(true);
            HomeModel homemodel = new HomeModel();
            HomeController homeController = new HomeController(homeview, homemodel);
        }
        else
        {
            System.out.println("Incorrect Password. Please try again");
            
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.setVisible(true);
            LoginModel loginModel = new LoginModel();
            LoginController loginController = new LoginController(loginScreen, loginModel);
        }


    }
    
}