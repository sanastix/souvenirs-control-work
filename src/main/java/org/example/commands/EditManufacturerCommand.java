package org.example.commands;

import org.example.Menu;

public class EditManufacturerCommand extends Command {

    private final String filePath = "Manufacturers.txt";

    public EditManufacturerCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        return false;
    }

}
