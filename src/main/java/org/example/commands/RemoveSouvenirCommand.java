package org.example.commands;

import org.example.Menu;

public class RemoveSouvenirCommand extends Command {

    private final String filePath = "Souvenirs.txt";

    RemoveSouvenirCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
