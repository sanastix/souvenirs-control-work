package org.example.menu;

import org.example.FileParser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.List;

public class Menu extends JFrame {

    private final JTextField sId = new JTextField(10);
    private final JTextField sName = new JTextField(10);
    private final JTextField sManDetails = new JTextField(10);
    private final JTextField sReleaseDate = new JTextField(10);
    private final JTextField sPrice = new JTextField(10);

    private final JTextField mId = new JTextField(10);
    private final JTextField mName = new JTextField(10);
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

    private final JTextField enterSName = new JTextField(10);
    private final JComboBox sByManBox = new JComboBox();
    private final JComboBox sByCountryBox = new JComboBox();
    private final JComboBox sByYearBox = new JComboBox();
    private final JTextField minSPrice = new JTextField(10);
    private final JTextField maxSPrice = new JTextField(10);
    private final JButton showAllSouvenirsButton = new JButton("Show all");
    private final JButton filterSouvenirsButton = new JButton("Filter");

    private final JTextField enterMName = new JTextField(10);
    private final JComboBox mByCountryBox = new JComboBox();
    private final JTextField minMPrice = new JTextField(10);
    private final JTextField maxMPrice = new JTextField(10);
    private final JButton showAllManufacturersButton = new JButton("Show all");
    private final JButton filterManufacturersButton = new JButton("Filter");
    private final JButton showAllManufacturersWithItsSouvenirsButton = new JButton("Show database");

    private final FileParser parser = new FileParser(this);
    private final JPanel content = new JPanel();
    private final JTable table = new JTable();
    private final JScrollPane scrollPane = new JScrollPane();

    public final JFrame removeFrame = new JFrame("Remove manufacturer with all its items?");

    public void updateTable(){
        scrollPane.setViewportView(table);
        content.add(scrollPane);
        DefaultTableModel newModel = new DefaultTableModel();
        Object[] column = parser.souvenirColumnNames;
        newModel.setColumnIdentifiers(column);
        List<String> souvenirsBase = parser.readSouvenirsBase().stream().sorted().toList();
        Object[] row;
        if (!souvenirsBase.isEmpty()){
            for (String s : souvenirsBase) {
                row = s.split(":");
                newModel.addRow(row);
            }
        }
        table.setModel(newModel);
    }

    public void showResultTable(DefaultTableModel newModel, String tableName) {
        JFrame jFrame = new JFrame(tableName);
        JPanel jPanel = new JPanel();
        jFrame.setSize(700, 600);
        jFrame.setContentPane(jPanel);
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

        JTable jTable = new JTable();
        JScrollPane jScrollPane = new JScrollPane();

        jScrollPane.setBounds(0,0,700,600);
        jTable.setBounds(0,0,700,600);

        jScrollPane.setViewportView(jTable);
        jPanel.add(jScrollPane);
        jTable.setModel(newModel);

        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    public void init(){
        JFrame frame = new JFrame("Souvenirs and manufacturers manager");
        frame.setSize(1000, 800);
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        JLabel souvenirsLabel = new JLabel("Souvenirs", JLabel.CENTER);
        JLabel sIdLabel = new JLabel("id: ");
        JLabel sNameLabel = new JLabel("name: ");
        JLabel sManDetailsLabel = new JLabel("manufacturer's name: ");
        JLabel sReleaseDateLabel = new JLabel("release year: ");
        JLabel sPriceLabel = new JLabel("price: ");

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

        JLabel manufacturersLabel = new JLabel("Manufacturers", JLabel.CENTER);
        JLabel mIdLabel = new JLabel("id: ");
        JLabel mNameLabel = new JLabel("name: ");
        JLabel mCountryLabel = new JLabel("country: ");

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

        JLabel filterSouvenirs = new JLabel("Filter souvenirs");
        JLabel sByName = new JLabel("by name:");
        JLabel sByManufacturer = new JLabel("by manufacturer: ");
        JLabel sByCountry = new JLabel("by country: ");
        JLabel sByReleaseYear = new JLabel("by release year: ");
        JLabel sByPrice = new JLabel("by price: ");

        filterSouvenirs.setBounds(60,260,150,20);
        content.add(filterSouvenirs);
        sByName.setBounds(90,290,100,20);
        content.add(sByName);
        enterSName.setBounds(170,290,80,20);
        content.add(enterSName);
        sByManufacturer.setBounds(90,310,150,20);
        content.add(sByManufacturer);
        sByManBox.setBounds(100,330,150,20);
        sByManBox.addItem(null);
        for (String manName : parser.manufacturerNamesList()){
            sByManBox.addItem(manName);
        }
        content.add(sByManBox);
        sByCountry.setBounds(90,350,150,20);
        content.add(sByCountry);
        sByCountryBox.setBounds(100,370,150,20);
        sByCountryBox.addItem(null);
        for (String country : parser.countryList()){
            sByCountryBox.addItem(country);
        }
        content.add(sByCountryBox);
        sByReleaseYear.setBounds(90,390,150,20);
        content.add(sByReleaseYear);
        sByYearBox.setBounds(100,410,150,20);
        sByYearBox.addItem(null);
        for (String year : parser.releaseYearList()){
            sByYearBox.addItem(year);
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

        JLabel filterManufacturers = new JLabel("Filter manufacturers");
        JLabel mByName = new JLabel("by name:");
        JLabel mByCountry = new JLabel("by country: ");
        JLabel mByPrice = new JLabel("by price: ");

        filterManufacturers.setBounds(60,530,150,20);
        content.add(filterManufacturers);
        mByName.setBounds(90,560,100,20);
        content.add(mByName);
        enterMName.setBounds(170,560,80,20);
        content.add(enterMName);
        mByCountry.setBounds(90,580,150,20);
        content.add(mByCountry);
        mByCountryBox.setBounds(100,600,150,20);
        mByCountryBox.addItem(null);
        for (String country : parser.countryList()){
            mByCountryBox.addItem(country);
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
        showAllManufacturersWithItsSouvenirsButton.setBounds(80, 700, 190, 20);
        content.add(showAllManufacturersWithItsSouvenirsButton);

        scrollPane.setBounds(300,290,640,430);
        JLabel tableLabel = new JLabel("Initial souvenirs base", JLabel.CENTER);
        tableLabel.setBounds(450, 260, 300, 20);
        content.add(tableLabel);
        updateTable();

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public void removeManWithItems(){
        JPanel content = new JPanel();
        removeFrame.setSize(400, 200);
        removeFrame.setContentPane(content);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        removeManWithItemsLabel.setBounds(50,50,300,30);
        content.add(removeManWithItemsLabel);
        yesButton.setBounds(70, 100, 100, 30);
        content.add(yesButton);
        noButton.setBounds(230, 100, 100, 30);
        content.add(noButton);

        removeFrame.setLocationRelativeTo(null);
        removeFrame.setLayout(null);
        removeFrame.setVisible(true);
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

    public String getSouvenirName(){
        if (!enterSName.getText().isEmpty()){
            return enterSName.getText();
        }
        return null;
    }

    public String getManNameOfBox(){
        if (sByManBox.getSelectedItem() != null){
            return (String) sByManBox.getSelectedItem();
        }
        return null;
    }

    public String getSCountryOfBox(){
        if (sByCountryBox.getSelectedItem() != null){
            return (String) sByCountryBox.getSelectedItem();
        }
        return null;
    }

    public String getSYearOfBox(){
        if (sByYearBox.getSelectedItem() != null){
            return (String) sByYearBox.getSelectedItem();
        }
        return null;
    }

    public String getMinSPrice(){
        if (!minSPrice.getText().isEmpty()){
            return minSPrice.getText();
        }
        return null;
    }

    public String getMaxSPrice(){
        if (!maxSPrice.getText().isEmpty()){
            return maxSPrice.getText();
        }
        return null;
    }

    public String getManufacturerName(){
        if (!enterMName.getText().trim().isEmpty()){
            return enterMName.getText();
        }
        return null;
    }

    public String getMCountryOfBox(){
        if (mByCountryBox.getSelectedItem() != null){
            return (String) mByCountryBox.getSelectedItem();
        }
        return null;
    }

    public String getMinMPrice(){
        if (!minMPrice.getText().isEmpty()){
            return minMPrice.getText();
        }
        return null;
    }

    public String getMaxMPrice(){
        if (!maxMPrice.getText().isEmpty()){
            return maxMPrice.getText();
        }
        return null;
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

    public void addShowAllManufacturersWithItsSouvenirsListener(ActionListener listenToShowDatabaseButton){
        showAllManufacturersWithItsSouvenirsButton.addActionListener(listenToShowDatabaseButton);
    }

    public void displayResultMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    public void displayErrorMessage(String error) {
        JOptionPane.showMessageDialog(this, error);
    }
}
