package com.breweetristan.swing;

import javax.swing.*;

public class MainWindow {

    private JFrame window;

    /*
    Constructor
     */
    public MainWindow(){
        initialize();
    }

    /*
    Set all the initial values of the JFrame
     */
    private void initialize(){
        window = new JFrame();
        window.setTitle("Simple calculator");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(800, 500);
        window.setResizable(false);
        window.setLocationRelativeTo(null); //This centers the JFrame
    }

    /*
    This method makes the JFrame visible
     */
    public void show(){
        window.setVisible(true);
    }
}
