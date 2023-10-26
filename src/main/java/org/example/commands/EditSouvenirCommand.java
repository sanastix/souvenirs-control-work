package org.example.commands;

import org.example.Menu;

public class EditSouvenirCommand extends Command {

    private final String filePath = "Souvenirs.txt";

    EditSouvenirCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        return false;
    }

}
