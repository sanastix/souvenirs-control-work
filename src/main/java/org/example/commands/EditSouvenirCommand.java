package org.example.commands;

import org.example.FileParser;
import org.example.Menu;

import java.util.Arrays;
import java.util.List;

public class EditSouvenirCommand extends Command {

    private final FileParser parser = new FileParser(menu);

    public EditSouvenirCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        List<String> editedSouvenir = Arrays.stream(menu.getSouvenir().split(":")).toList();
        List<List<String>> souvenirsBase = parser.readSplitSouvenirsBase();
        try{
            for (List<String> souvenir : souvenirsBase) {
                if (souvenir.get(0).equals(editedSouvenir.get(0))){
                    souvenirsBase.add(souvenirsBase.indexOf(souvenir), editedSouvenir);
                    souvenirsBase.remove(souvenir);
                    break;
                }
            }
            parser.writeSplitSouvenirsBase(souvenirsBase);
        } catch (Exception e){
            return false;
        }
        return true;
    }

}
