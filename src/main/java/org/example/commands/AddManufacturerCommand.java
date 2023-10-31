package org.example.commands;

import org.example.menu.Menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class AddManufacturerCommand extends Command {

    private final String MANUFACTURERS_DB = "Manufacturers.txt";
    private final File manufacturersDB = new File(MANUFACTURERS_DB);

    public AddManufacturerCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        String manufacturer = menu.getManufacturer();
        try(FileWriter fileWriter = new FileWriter(manufacturersDB, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(manufacturer);
            bufferedWriter.newLine();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
