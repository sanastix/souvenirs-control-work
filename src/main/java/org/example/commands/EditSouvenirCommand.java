package org.example.commands;

import org.example.FileParser;
import org.example.Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EditSouvenirCommand extends Command {

/*    private final String SOUVENIRS_DB = "Souvenirs.txt";
    private final File souvenirsDB = new File(SOUVENIRS_DB);*/
    private final FileParser parser = new FileParser(menu);

    public EditSouvenirCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        List<String> editedSouvenir = Arrays.stream(menu.getSouvenir().split(":")).toList();
        List<List<String>> souvenirsBase = parser.readSplittedSouvenirsBase();

        try{
            for (List<String> souvenir : souvenirsBase) {
                if ((souvenir.get(0)).equals(editedSouvenir.get(0))){
                    souvenirsBase.add(souvenirsBase.indexOf(souvenir), editedSouvenir);
                    souvenirsBase.remove(souvenir);
                    break;
                }
            }
            parser.writeSouvenirsBase(souvenirsBase);
        } catch (Exception e){
            menu.displayErrorMessage(e.toString());
            return false;
        }
        return true;
    }

}
