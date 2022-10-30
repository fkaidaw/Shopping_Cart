/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author fahim
 */
public class LoginController implements ActionListener
{
    public LoginScreen view;
    public LoginModel model;
    
    public LoginController(LoginScreen view , LoginModel model)
    {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        switch (command)
        {
            case "Login":
                String username = this.view.getUsernameField().getText();
                String password = this.view.getPasswordField().getText();
                this.model.checkName(username, password);
                break;
            case "Exit":
                this.view.dispose();
                break;
            default:
                break;
                
        }
    }
}

