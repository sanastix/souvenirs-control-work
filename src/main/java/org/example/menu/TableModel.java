package org.example.menu;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel{

    private final List<List<String>> data;
    private final String[] columnNames;

    public TableModel(List<List<String>> data, String[] columnNames) {
        this.data = data;
        this.columnNames = columnNames;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }

    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}
