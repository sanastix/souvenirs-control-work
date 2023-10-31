package org.example.commands;

import org.example.menu.Menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class AddSouvenirCommand extends Command {

    private final String SOUVENIRS_DB = "Souvenirs.txt";
    private final File souvenirsDB = new File(SOUVENIRS_DB);

    public AddSouvenirCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        String souvenir = menu.getSouvenir();
        try(FileWriter fileWriter = new FileWriter(souvenirsDB, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(souvenir);
            bufferedWriter.newLine();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
