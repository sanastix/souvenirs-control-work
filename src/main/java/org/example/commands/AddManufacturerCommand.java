package org.example.commands;

import org.example.Menu;

public class AddManufacturerCommand extends Command {

    private final String filePath = "Manufacturers.txt";

    AddManufacturerCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        return false;
    }

}
