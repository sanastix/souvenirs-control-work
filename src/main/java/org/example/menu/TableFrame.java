package org.example.menu;

import org.example.filters.ShowAllSouvenirs;

public class TableFrame {

    private final Menu menu = new Menu();
    //private ShowAllSouvenirs showAllSouvenirs = new ShowAllSouvenirs();
    //private TableModel tableModel = showAllSouvenirs.show();
    private TableModel tableModel;

    public void updateTableData(TableModel tableModel) {
        tableModel.fireTableDataChanged();
        //menu.table.setModel(tableModel);
        setTableModel(tableModel);
    }

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    public TableModel getTableModel() {
        return this.tableModel;
    }

    /*    public TableModel getModel(){
        //menu.table.setModel(tableModel);
        return this.tableModel;
    }*/

}
