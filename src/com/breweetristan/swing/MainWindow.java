package com.breweetristan.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow implements ActionListener {

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
        window.setSize(450, 500);
        window.setResizable(false);
        window.setLocationRelativeTo(null); //This centers the JFrame

        addLayouts();
    }

    /*
    Add the Layouts to the JFrame
     */
    private void addLayouts(){
        /*
        Add the TextArea to the top center
         */
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout(15, 15));

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
        topPanel.add(textArea);

        window.add(topPanel, BorderLayout.NORTH);

        /*
        Add the buttons to the center
         */
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 4, 5, 5));

        addButtons(centerPanel);

        window.add(centerPanel, BorderLayout.CENTER);
    }

    /*
    Create the JButtons
    Add their ActionListeners
    Add the JButtons to the centerPanel
     */
    private void addButtons(JPanel centerPanel){
        JButton btnOne = new JButton("1");
        JButton btnTwo = new JButton("2");
        JButton btnThree = new JButton("3");
        JButton btnFour = new JButton("4");
        JButton btnFive = new JButton("5");
        JButton btnSix = new JButton("6");
        JButton btnSeven = new JButton("7");
        JButton btnEight = new JButton("8");
        JButton btnNine = new JButton("9");
        JButton btnZero = new JButton("0");
        JButton btnEquals = new JButton("=");
        JButton btnDot = new JButton(".");
        JButton btnAdd = new JButton("+");
        JButton btnSubtract = new JButton("-");
        JButton btnMultiply = new JButton("*");
        JButton btnDivide = new JButton("/");

        btnOne.addActionListener(this);
        btnTwo.addActionListener(this);
        btnThree.addActionListener(this);
        btnFour.addActionListener(this);
        btnFive.addActionListener(this);
        btnSix.addActionListener(this);
        btnSeven.addActionListener(this);
        btnEight.addActionListener(this);
        btnNine.addActionListener(this);
        btnZero.addActionListener(this);
        btnDot.addActionListener(this);
        btnAdd.addActionListener(this);
        btnSubtract.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnDivide.addActionListener(this);

        /*
        The equals button needs its own ActionListener
         */

        centerPanel.add(btnOne);
        centerPanel.add(btnTwo);
        centerPanel.add(btnThree);
        centerPanel.add(btnAdd);
        centerPanel.add(btnFour);
        centerPanel.add(btnFive);
        centerPanel.add(btnSix);
        centerPanel.add(btnSubtract);
        centerPanel.add(btnSeven);
        centerPanel.add(btnEight);
        centerPanel.add(btnNine);
        centerPanel.add(btnMultiply);
        centerPanel.add(btnDot);
        centerPanel.add(btnZero);
        centerPanel.add(btnEquals);
        centerPanel.add(btnDivide);
    }

    /*
    This method makes the JFrame visible
     */
    public void show(){
        window.setVisible(true);
    }

    /*
    This method is called when a button is clicked (except the "equals" button)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)(e.getSource());
        TextArea txtArea = (TextArea)(window.getContentPane().getComponent(0).getComponentAt(0, 0));
        txtArea.setText(txtArea.getText() + source.getText());
    }
}
