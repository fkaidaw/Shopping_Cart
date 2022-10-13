/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

import java.util.Observable;
import java.util.Random;

/**
 *
 * @author fahim
 */
public class LoginModel extends Observable
{
    public Database db;
    public Data data;
    public int answer = 0;
    public String username;
    
    public LoginModel()
    {
        this.db = new Database();
        this.db.dbsetup();
    }

    public void checkName(String username, String password)
    {
        this.username = username;
        this.data = this.db.checkName(username, password);
        
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void quitGame()
    {
        this.data.quitFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
}