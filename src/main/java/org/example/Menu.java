package org.example;

import javax.swing.*;
import java.awt.*;

public class Menu {

    public JTextArea textField;
    public String clipboard;

    public void init(){
        JFrame frame = new JFrame();
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));

        /*
        JButton addMovie = new JButton("Add movie to the catalogue");
        JButton watchCatalogue = new JButton("Watch catalogue");
        JButton addCustomer = new JButton("Add customer");
        JButton watchCustomers = new JButton("Watch customers");
        */

        //commands?

        Menu menu = this;

        //actionlistener

        content.add(buttons);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
