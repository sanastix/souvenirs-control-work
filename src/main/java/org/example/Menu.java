package org.example;

import javax.swing.*;

public class Menu extends JFrame {

    public JLabel souvenirsLabel = new JLabel("Souvenirs", JLabel.CENTER);
    public JLabel sIdLabel = new JLabel("id: ", JLabel.LEFT);
    public JTextField sId = new JTextField(10);
    public JLabel sNameLabel = new JLabel("name: ");
    public JTextField sName = new JTextField(10);
    public JLabel sManDetailsLabel = new JLabel("manufacturer's details: ");
    public JTextField sManDetails = new JTextField(10);
    public JLabel sReleaseDateLabel = new JLabel("release year: ");
    public JTextField sReleaseDate = new JTextField(10);
    public JLabel sPriceLabel = new JLabel("price: ");
    public JTextField sPrice = new JTextField(10);

    public JLabel manufacturersLabel = new JLabel("Manufacturers", JLabel.CENTER);
    public JLabel mIdLabel = new JLabel("id: ");
    public JTextField mId = new JTextField(10);
    public JLabel mNameLabel = new JLabel("name: ");
    public JTextField mName = new JTextField(10);
    public JLabel mCountryLabel = new JLabel("country: ");
    public JTextField mCountry = new JTextField(10);

    public JButton sRemove = new JButton("Remove");
    public JButton sEdit = new JButton("Edit");
    public JButton sAdd = new JButton("Add");
    public JButton sFind = new JButton("Find");

    public JButton mRemove = new JButton("Remove");
    public JButton mEdit = new JButton("Edit");
    public JButton mAdd = new JButton("Add");
    public JButton mFind = new JButton("Find");

    JTable table = new JTable();

    public JTextField textField;

    public void init(){
        JFrame frame = new JFrame("Менеджер сувенірів та їх виробників");
        JPanel content = new JPanel();
        frame.setSize(1000, 700);
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        souvenirsLabel.setBounds(160,20,200,20);
        frame.add(souvenirsLabel);
        sIdLabel.setBounds(80, 60, 100, 20);
        content.add(sIdLabel);
        sId.setBounds(250, 60, 200,20);
        content.add(sId);
        sNameLabel.setBounds(80,80, 100,20);
        content.add(sNameLabel);
        sName.setBounds(250,80,200,20);
        content.add(sName);
        sManDetailsLabel.setBounds(80,100,200,20);
        content.add(sManDetailsLabel);
        sManDetails.setBounds(250,100,200,20);
        content.add(sManDetails);
        sReleaseDateLabel.setBounds(80,120,100,20);
        content.add(sReleaseDateLabel);
        sReleaseDate.setBounds(250,120,200,20);
        content.add(sReleaseDate);
        sPriceLabel.setBounds(80,140,100,20);
        content.add(sPriceLabel);
        sPrice.setBounds(250,140,200,20);
        content.add(sPrice);

        manufacturersLabel.setBounds(620, 20,200,20);
        content.add(manufacturersLabel);
        mIdLabel.setBounds(560,60,100,20);
        content.add(mIdLabel);
        mId.setBounds(720,60,200,20);
        content.add(mId);
        mNameLabel.setBounds(560,80,100,20);
        content.add(mNameLabel);
        mName.setBounds(720,80,200,20);
        content.add(mName);
        mCountryLabel.setBounds(560,100,100,20);
        content.add(mCountryLabel);
        mCountry.setBounds(720,100,200,20);
        content.add(mCountry);

        sRemove.setBounds(80,180,90,20);
        content.add(sRemove);
        sEdit.setBounds(195,180,70,20);
        content.add(sEdit);
        sAdd.setBounds(285, 180,70,20);
        content.add(sAdd);
        sFind.setBounds(380,180,70,20);
        content.add(sFind);

        mRemove.setBounds(560,180,90,20);
        content.add(mRemove);
        mEdit.setBounds(670,180,70,20);
        content.add(mEdit);
        mAdd.setBounds(760, 180,70,20);
        content.add(mAdd);
        mFind.setBounds(850,180,70,20);
        content.add(mFind);

        table.setBounds(80,300,840,300);
        content.add(table);

        Menu menu = this;

        //actionlistener

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
