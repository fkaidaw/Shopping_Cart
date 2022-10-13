/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author fahim
 */
public class LoginView extends JFrame implements Observer
{
    private JPanel userPanel = new JPanel();
    private JPanel calcPanel = new JPanel();
    private JLabel uName = new JLabel ("Username: ");
    private JLabel pWord = new JLabel ("Password: ");
    public JTextField unInput = new JTextField(10);
    public JTextField pwInput = new JTextField(10);
    private JLabel wrongName = new JLabel("Wrong username or password");
    
    //private JTextField secondNumber = new JTextField(10);
    private JButton quitButton = new JButton("Quit");
    private JButton loginButton = new JButton("Log in");
    
    public JLabel message = new JLabel("Welcome to #####!", JLabel.CENTER);
    
    private boolean started = false; // To identify if the game part starts
    
    public LoginView()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        this.setLocationRelativeTo(null);
        this.userPanel.add(uName);
        this.userPanel.add(unInput);
        this.userPanel.add(pWord);
        this.userPanel.add(pwInput);  
        this.userPanel.add(loginButton);
        this.userPanel.add(quitButton);
        this.add(this.message, BorderLayout.SOUTH);
        this.add(userPanel);
        this.setVisible(true);   
    }

    public void addActionListener(ActionListener listener)
    {
        this.loginButton.addActionListener(listener);
        this.quitButton.addActionListener(listener);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        Data data = (Data) arg;
        if (!data.loginFlag)  
        {
            this.unInput.setText("");
            this.pwInput.setText("");
            this.message.setText("Invalid username or password.");
        } 
        else if (!this.started)
        {
            this.started = true;
        } 
    }
}
