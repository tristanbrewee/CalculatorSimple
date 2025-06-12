package com.breweetristan.swing;

import javax.swing.*;

public class Launcher {

    /*
    This method launched the Swing window
    Swing is not threadsafe so we use a single thread
     */
    public static void launch(){
        SwingUtilities.invokeLater(() -> {
            MainWindow main = new MainWindow();
            main.show();
        });
    }
}
