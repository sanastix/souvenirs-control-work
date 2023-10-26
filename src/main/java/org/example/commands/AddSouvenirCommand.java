package org.example.commands;

import org.example.Menu;

public class AddSouvenirCommand extends Command {

    private final String filePath = "Souvenirs.txt";

    AddSouvenirCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        return false;
    }

}
