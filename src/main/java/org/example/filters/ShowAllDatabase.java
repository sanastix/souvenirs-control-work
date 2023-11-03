package org.example.filters;

import org.example.FileParser;
import org.example.menu.Menu;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ShowAllDatabase {

    private final Menu menu = new Menu();
    private final FileParser parser = new FileParser(menu);

    public void show() {
        DefaultTableModel newModel = new DefaultTableModel();
        Object[] column = parser.databaseColumnNames;
        newModel.setColumnIdentifiers(column);

        List<List<String>> souvenirsBase = parser.readSplitSouvenirsBase();
        List<List<String>> manufacturersBase = parser.readSplitManufacturersBase();

        int rowNumber = 1;
        Object[] row = new Object[column.length];

        if (!souvenirsBase.isEmpty() && !manufacturersBase.isEmpty()){
            for (List<String> souvenir : souvenirsBase){
                row[0] = rowNumber;
                row[1] = souvenir.get(1);
                row[2] = souvenir.get(2);
                for (List<String> strings : manufacturersBase) {
                    String[] mParts = strings.toArray(new String[0]);
                    if (mParts[1].equals(souvenir.get(2))) {
                        row[3] = mParts[2];
                        break;
                    }
                }
                row[4] = souvenir.get(3);
                row[5] = souvenir.get(4);
                newModel.addRow(row);
                rowNumber++;
            }
        }
        menu.showResultTable(newModel, "Database");
    }
}
