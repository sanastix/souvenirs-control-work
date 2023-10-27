package org.example.commands;

import org.example.FileParser;
import org.example.Menu;

import java.util.List;

public class RemoveSouvenirCommand extends Command {

    private final FileParser parser = new FileParser(menu);

    public RemoveSouvenirCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        String souvenirToRemove = menu.getSouvenir();
        List<String> souvenirsBase = parser.readSouvenirsBase();
        boolean removed = false;
        try {
            for (String souvenir : souvenirsBase){
                if (souvenir.equals(souvenirToRemove)){
                    souvenirsBase.remove(souvenir);
                    removed = true;
                    break;
                }
            }
            if (removed) {
                parser.writeSouvenirsBase(souvenirsBase);
            } else {
                menu.displayErrorMessage("No item to remove");
            }
        } catch (Exception e){
            menu.displayErrorMessage(String.valueOf(e));
        }
        return removed;
    }
}
