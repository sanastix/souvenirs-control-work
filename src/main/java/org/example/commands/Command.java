package org.example.commands;

import org.example.Menu;

public abstract class Command {

    public Menu menu;
//    private String backup;

    Command(Menu menu){
        this.menu = menu;
    }

/*    void backup() {
        backup = menu.textField.getText();
    }

    public void undo() {
        menu.textField.setText(backup);
    }*/

    public abstract boolean execute();

}
