package com.breweetristan.swing;

import com.breweetristan.calculations.CalculationClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_ENTER;

public class MainWindow implements ActionListener {

    private JFrame window;
    private boolean equalsBtnPressed = false;

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
        textArea.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
        topPanel.add(textArea);
        /*
        Add a KeyListener so the Enter-key will do the same thing as the equals key
         */
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == VK_ENTER ){
                    textArea.setText(textArea.getText().replace("\n", ""));
                    equalsBtnPressed = true;
                    textArea.setText(CalculationClass.start(textArea.getText()));
                }
            }
        });

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
        The entered equation is processed by the CalculationClass
        The output is printed underneath the equation
        The flag "equalsBtnPressed" is turned on
         */
        btnEquals.addActionListener(e -> {
            TextArea txtArea = (TextArea)(window.getContentPane().getComponent(0).getComponentAt(0, 0));
            String calculationString = txtArea.getText();
            if (!equalsBtnPressed){
                String output = CalculationClass.start(calculationString);
                txtArea.setText(txtArea.getText() + "\n" + output);
                equalsBtnPressed = true;
            }
        });

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
    The text on the button pressed is added to the textField
    If the "equals" button was pressed right before, then the textField is cleared first
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)(e.getSource());
        TextArea txtArea = (TextArea)(window.getContentPane().getComponent(0).getComponentAt(0, 0));
        if (equalsBtnPressed) {
            txtArea.setText("");
            equalsBtnPressed = false;
        }
        txtArea.setText(txtArea.getText() + source.getText());
    }
}
