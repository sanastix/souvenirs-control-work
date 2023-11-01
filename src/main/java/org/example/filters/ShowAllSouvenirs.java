package org.example.filters;

import org.example.FileParser;
import org.example.menu.Menu;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ShowAllSouvenirs {

    private final Menu menu = new Menu();
    private final FileParser parser = new FileParser(menu);

    public void show(){
        DefaultTableModel newModel = new DefaultTableModel();
        Object[] column = parser.souvenirColumnNames;
        newModel.setColumnIdentifiers(column);
        List<String> souvenirsBase = parser.readSouvenirsBase().stream().sorted().toList();
        Object[] row;
        for (int i = 0; i < column.length; i++){
            row = souvenirsBase.get(i).split(":");
            newModel.addRow(row);
        }
        menu.showResultTable(newModel, "Souvenirs database");
    }

}