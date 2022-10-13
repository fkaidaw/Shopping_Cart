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
    public LoginView view;
    public LoginModel model;
    
    public LoginController(LoginView view , LoginModel model)
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
            case "Log in":
                String username = this.view.unInput.getText();
                String password = this.view.pwInput.getText();
                this.model.checkName(username, password);
                break;
            case "Quit":
                this.model.quitGame();
                break;
            default:
                break;
                
        }
    }
}

