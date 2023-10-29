package org.example;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class Menu extends JFrame {

    private final JLabel souvenirsLabel = new JLabel("Souvenirs", JLabel.CENTER);
    private final JLabel sIdLabel = new JLabel("id: ");
    private final JTextField sId = new JTextField(10);
    private final JLabel sNameLabel = new JLabel("name: ");
    private final JTextField sName = new JTextField(10);
    private final JLabel sManDetailsLabel = new JLabel("manufacturer's name: ");
    private final JTextField sManDetails = new JTextField(10);
    private final JLabel sReleaseDateLabel = new JLabel("release year: ");
    private final JTextField sReleaseDate = new JTextField(10);
    private final JLabel sPriceLabel = new JLabel("price: ");
    private final JTextField sPrice = new JTextField(10);

    private final JLabel manufacturersLabel = new JLabel("Manufacturers", JLabel.CENTER);
    private final JLabel mIdLabel = new JLabel("id: ");
    private final JTextField mId = new JTextField(10);
    private final JLabel mNameLabel = new JLabel("name: ");
    private final JTextField mName = new JTextField(10);
    private final JLabel mCountryLabel = new JLabel("country: ");
    private final JTextField mCountry = new JTextField(10);

    private final JButton sRemove = new JButton("Remove");
    private final JButton sEdit = new JButton("Edit");
    private final JButton sAdd = new JButton("Add");

    private final JButton mRemove = new JButton("Remove");
    private final JButton mEdit = new JButton("Edit");
    private final JButton mAdd = new JButton("Add");

    private final JLabel removeManWithItemsLabel = new JLabel("Remove manufacturer with all its items?", JLabel.CENTER);
    private final JButton yesButton = new JButton("Yes");
    private final JButton noButton = new JButton("No");

    private final JLabel filterSouvenirs = new JLabel("Filter souvenirs");
    private final JLabel sByName = new JLabel("by name:");
    private final JTextField enterSName = new JTextField();
    private final JLabel sByManufacturer = new JLabel("by manufacturer: ");
    private final JComboBox sByManBox = new JComboBox();
    private final JLabel sByCountry = new JLabel("by country: ");
    private final JComboBox sByCountryBox = new JComboBox();
    private final JLabel sByReleaseYear = new JLabel("by release year: ");
    private final JComboBox sByYearBox = new JComboBox();
    private final JLabel sByPrice = new JLabel("by price: ");
    private final JTextField minSPrice = new JTextField();
    private final JTextField maxSPrice = new JTextField();
    private final JButton showAllSouvenirsButton = new JButton("Show all");
    private final JButton filterSouvenirsButton = new JButton("Filter");

    private final JLabel filterManufacturers = new JLabel("Filter manufacturers");
    private final JLabel mByName = new JLabel("by name:");
    private final JTextField enterMName = new JTextField();
    private final JLabel mByCountry = new JLabel("by country: ");
    private final JComboBox mByCountryBox = new JComboBox();
    private final JLabel mByPrice = new JLabel("by price: ");
    private final JTextField minMPrice = new JTextField();
    private final JTextField maxMPrice = new JTextField();
    private final JButton showAllManufacturersButton = new JButton("Show all");
    private final JButton filterManufacturersButton = new JButton("Filter");

    private final JTable table = new JTable();

    public void init(){
        JFrame frame = new JFrame("Souvenirs and manufacturers manager");
        JPanel content = new JPanel();
        frame.setSize(1000, 800);
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        FileParser parser = new FileParser(this);

        //make it unique (Set?)
        List<List<String>> manufacturersBAse = parser.readSplitManufacturersBase();
        List<List<String>> souvenirsBase = parser.readSplitSouvenirsBase();

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

        mRemove.setBounds(560,180,90,20);
        content.add(mRemove);
        mEdit.setBounds(670,180,70,20);
        content.add(mEdit);
        mAdd.setBounds(760, 180,70,20);
        content.add(mAdd);

        filterSouvenirs.setBounds(60,260,150,20);
        content.add(filterSouvenirs);
        sByName.setBounds(90,290,100,20);
        content.add(sByName);
        enterSName.setBounds(170,290,80,20);
        content.add(enterSName);
        sByManufacturer.setBounds(90,310,150,20);
        content.add(sByManufacturer);
        sByManBox.setBounds(100,330,150,20);
        for (List<String> manufacturer : manufacturersBAse){
            sByManBox.addItem(manufacturer.get(1));
        }
        content.add(sByManBox);
        sByCountry.setBounds(90,350,150,20);
        content.add(sByCountry);
        sByCountryBox.setBounds(100,370,150,20);
        for (List<String> manufacturer : manufacturersBAse){
            sByCountryBox.addItem(manufacturer.get(2));
        }
        content.add(sByCountryBox);
        sByReleaseYear.setBounds(90,390,150,20);
        content.add(sByReleaseYear);
        sByYearBox.setBounds(100,410,150,20);
        for (List<String> souvenir : souvenirsBase){
            sByYearBox.addItem(souvenir.get(3));
        }
        content.add(sByYearBox);
        sByPrice.setBounds(90,430,150,20);
        content.add(sByPrice);
        minSPrice.setBounds(100,450,70,20);
        content.add(minSPrice);
        maxSPrice.setBounds(180,450,70,20);
        content.add(maxSPrice);
        showAllSouvenirsButton.setBounds(80,480,100,20);
        content.add(showAllSouvenirsButton);
        filterSouvenirsButton.setBounds(190,480,80,20);
        content.add(filterSouvenirsButton);

        filterManufacturers.setBounds(60,530,150,20);
        content.add(filterManufacturers);
        mByName.setBounds(90,560,100,20);
        content.add(mByName);
        enterMName.setBounds(170,560,80,20);
        content.add(enterMName);
        mByCountry.setBounds(90,580,150,20);
        content.add(mByCountry);
        mByCountryBox.setBounds(100,600,150,20);
        for (List<String> manufacturer : manufacturersBAse){
            mByCountryBox.addItem(manufacturer.get(2));
        }
        content.add(mByCountryBox);
        mByPrice.setBounds(90,620,150,20);
        content.add(mByPrice);
        minMPrice.setBounds(100,640,70,20);
        content.add(minMPrice);
        maxMPrice.setBounds(180,640,70,20);
        content.add(maxMPrice);
        showAllManufacturersButton.setBounds(80,670,100,20);
        content.add(showAllManufacturersButton);
        filterManufacturersButton.setBounds(190,670,80,20);
        content.add(filterManufacturersButton);

        table.setBounds(300,260,640,430);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        content.add(scrollPane);
        content.add(table);


        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void removeManWithItems(){
        JFrame frame = new JFrame("Remove manufacturer with all its items?");
        JPanel content = new JPanel();
        frame.setSize(400, 200);
        frame.setContentPane(content);
        //frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   //need smth else
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        removeManWithItemsLabel.setBounds(50,50,300,30);
        content.add(removeManWithItemsLabel);
        yesButton.setBounds(70, 100, 100, 30);
        content.add(yesButton);
        noButton.setBounds(230, 100, 100, 30);
        content.add(noButton);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public String getSouvenir(){
        if (sId.getText().isEmpty() || sName.getText().isEmpty() || sManDetails.getText().isEmpty() || sReleaseDate.getText().isEmpty() || sPrice.getText().isEmpty()){
            displayErrorMessage("Fill in all information");
        } else {
            return sId.getText() +":"+ sName.getText() +":"+sManDetails.getText() +":"+ sReleaseDate.getText() +":"+ sPrice.getText();
        }
        return null;
    }

    public String getManufacturer() {
        if (mId.getText().isEmpty() || mName.getText().isEmpty() || mCountry.getText().isEmpty()){
            displayErrorMessage("Fill in all information");
        } else {
            return mId.getText() +":"+ mName.getText() +":"+ mCountry.getText();
        }
        return null;
    }

    public int getSouvenirID() {
        if (sId.getText().isEmpty()){
            displayErrorMessage("Enter ID to find correct item");
        } else {
            return Integer.parseInt(sId.getText());
        }
        return 0;
    }

    public int getManufacturerID() {
        if (mId.getText().isEmpty()){
            displayErrorMessage("Enter ID to find correct item");
        } else {
            return Integer.parseInt(mId.getText());
        }
        return 0;
    }

    public void addRemoveSouvenirListener(ActionListener listenToRemoveSouvenirButton){
        sRemove.addActionListener(listenToRemoveSouvenirButton);
    }

    public void addEditSouvenirListener(ActionListener listenToEditSouvenirButton){
        sEdit.addActionListener(listenToEditSouvenirButton);
    }

    public void addAddSouvenirListener(ActionListener listenToAddSouvenirButton){
        sAdd.addActionListener(listenToAddSouvenirButton);
    }

    public void addRemoveManufacturerListener(ActionListener listenToRemoveManufacturerButton){
        mRemove.addActionListener(listenToRemoveManufacturerButton);
    }

    public void addEditManufacturerListener(ActionListener listenToEditManufacturerButton){
        mEdit.addActionListener(listenToEditManufacturerButton);
    }

    public void addAddManufacturerListener(ActionListener listenToAddManufacturerButton){
        mAdd.addActionListener(listenToAddManufacturerButton);
    }

    public void addYesRemoveManListener(ActionListener listenToYesRemoveManButton){
        yesButton.addActionListener(listenToYesRemoveManButton);
    }

    public void addNoRemoveManListener(ActionListener listenToNoRemoveManButton){
        noButton.addActionListener(listenToNoRemoveManButton);
    }

    public void addShowAllSouvenirsListener(ActionListener listenToShowAllSouvenirsButton){
        showAllSouvenirsButton.addActionListener(listenToShowAllSouvenirsButton);
    }

    public void addFilterSouvenirsListener(ActionListener listenToFilterSouvenirsButton){
        filterSouvenirsButton.addActionListener(listenToFilterSouvenirsButton);
    }

    public void addShowAllManufacturersListener(ActionListener listenToShowAllManufacturersButton){
        showAllManufacturersButton.addActionListener(listenToShowAllManufacturersButton);
    }

    public void addFilterManufacturersListener(ActionListener listenToFilterManufacturersButton){
        filterManufacturersButton.addActionListener(listenToFilterManufacturersButton);
    }

    public void displayResultMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    public void displayErrorMessage(String error) {
        JOptionPane.showMessageDialog(this, error);
    }
}
