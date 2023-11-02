package org.example.commands;

import org.example.FileParser;
import org.example.menu.Menu;

import java.util.Arrays;
import java.util.List;

public class EditSouvenirCommand extends Command {

    private final FileParser parser = new FileParser(menu);

    public EditSouvenirCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        String souvenirItem = menu.getSouvenir();
        List<List<String>> souvenirsBase = parser.readSplitSouvenirsBase();
        boolean edited = false;
        try{
            List<String> editedSouvenir = Arrays.stream(souvenirItem.split(":")).toList();
            for (List<String> souvenir : souvenirsBase) {
                if (souvenir.get(0).equals(editedSouvenir.get(0))){
                    souvenirsBase.add(souvenirsBase.indexOf(souvenir), editedSouvenir);
                    souvenirsBase.remove(souvenir);
                    edited = true;
                    break;
                }
            }
            if (edited){
                parser.writeSplitSouvenirsBase(souvenirsBase);
            } else {
                menu.displayErrorMessage("No item to edit");
            }
        } catch (Exception e){
            menu.displayErrorMessage(String.valueOf(e));
        }
        return edited;
    }

}
