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
public class HomeController implements ActionListener
{
    public HomeScreen view;
    public HomeModel model;
    
    public HomeController(HomeScreen view , HomeModel model)
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
            case "View all items":
                this.model.viewAllItems();
                break;
            case "View Cart":
                this.model.viewCart();
                break;
            case "Profile":
                this.model.viewProfile();
                break;
            case "Exit":
                this.model.quitGame();
                break;
            default:
                break;
                
        }
    }  
}

