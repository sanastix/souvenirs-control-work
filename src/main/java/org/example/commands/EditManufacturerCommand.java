package org.example.commands;

import org.example.FileParser;
import org.example.Menu;

import java.util.Arrays;
import java.util.List;

public class EditManufacturerCommand extends Command {

    private final FileParser parser = new FileParser(menu);

    public EditManufacturerCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        List<String> editedManufacturer = Arrays.stream(menu.getManufacturer().split(":")).toList();
        List<List<String>> manufacturersBase = parser.readSplitManufacturersBase();
        try {
            for (List<String> manufacturer : manufacturersBase) {
                if (manufacturer.get(0).equals(editedManufacturer.get(0))){
                    manufacturersBase.add(manufacturersBase.indexOf(manufacturer), editedManufacturer);
                    manufacturersBase.remove(manufacturer);
                    break;
                }
            }
            parser.writeManufacturersBase(manufacturersBase);
        } catch (Exception e){
            return false;
        }
        return true;
    }

}
