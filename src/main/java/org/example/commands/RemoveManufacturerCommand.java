package org.example.commands;

import org.example.Menu;

public class RemoveManufacturerCommand extends Command {

    private final String filePathSouvenirs = "Souvenirs.txt";
    private final String filePathManufacturers = "Manufacturers.txt";

    RemoveManufacturerCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
