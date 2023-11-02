package org.example.filters;

import org.example.menu.Menu;

public abstract class Filter {

    public Menu menu;

    Filter(Menu menu){
        this.menu = menu;
    }

    public abstract void filter();

}
