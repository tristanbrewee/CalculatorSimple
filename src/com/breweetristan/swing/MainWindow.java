package com.breweetristan.swing;

import javax.swing.*;

public class MainWindow {

    private JFrame window;

    /*
    Constructor
    Set up the default settings for the JFrame
     */
    public MainWindow(){
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
