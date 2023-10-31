package org.example.filters;

import org.example.FileParser;
import org.example.menu.Menu;
import org.example.menu.TableFrame;
import org.example.menu.TableModel;

public class ShowAllSouvenirs {

    private final Menu menu = new Menu();
    private final FileParser parser = new FileParser(menu);
    private final TableFrame tableFrame = new TableFrame();

/*    public ShowAllSouvenirs(Menu menu){
        this.menu = menu;
    }*/

    public void show(){
        TableModel tableModel = new TableModel(parser.readSplitSouvenirsBase(), parser.souvenirColumnNames);
        tableFrame.updateTableData(tableModel);
    }

}
