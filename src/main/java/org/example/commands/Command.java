package org.example.commands;

import org.example.menu.Menu;

public abstract class Command {

    public Menu menu;

    Command(Menu menu){
        this.menu = menu;
    }

    public abstract boolean execute();

}
