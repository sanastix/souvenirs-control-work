package org.example.commands;

import org.example.Menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddManufacturerCommand extends Command {

    private final String MANUFACTURERS_DB = "Manufacturers.txt";
    private final File manufacturersDB = new File(MANUFACTURERS_DB);

    public AddManufacturerCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        String souvenir = "";
        try(FileWriter fileWriter = new FileWriter(manufacturersDB, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(souvenir);
            bufferedWriter.newLine();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

}
