package main.java.unit06.adder;

import javax.swing.*;

public class Calculator {
    private JPanel myPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JTextField textField3;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
