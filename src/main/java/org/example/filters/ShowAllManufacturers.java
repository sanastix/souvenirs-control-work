package org.example.filters;

import org.example.FileParser;
import org.example.menu.Menu;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ShowAllManufacturers {

    private final Menu menu = new Menu();
    private final FileParser parser = new FileParser(menu);

    public void show() {
        DefaultTableModel newModel = new DefaultTableModel();
        Object[] column = parser.manufacturerColumnNames;
        newModel.setColumnIdentifiers(column);
        List<String> manufacturersBase = parser.readManufacturersBase().stream().sorted().toList();
        Object[] row;
        for (int i = 0; i < column.length; i++) {
            row = manufacturersBase.get(i).split(":");
            newModel.addRow(row);
        }
        menu.showResultTable(newModel, "Manufacturers database");
    }
}
