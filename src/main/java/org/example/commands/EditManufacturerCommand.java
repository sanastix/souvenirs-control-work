package org.example.commands;

import org.example.FileParser;
import org.example.menu.Menu;

import java.util.Arrays;
import java.util.List;

public class EditManufacturerCommand extends Command {

    private final FileParser parser = new FileParser(menu);

    public EditManufacturerCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        String manufacturerItem = menu.getManufacturer();
        List<List<String>> manufacturersBase = parser.readSplitManufacturersBase();
        boolean edited = false;
        try {
            List<String> editedManufacturer = Arrays.stream(manufacturerItem.split(":")).toList();
            for (List<String> manufacturer : manufacturersBase) {
                if (manufacturer.get(0).equals(editedManufacturer.get(0))){
                    manufacturersBase.add(manufacturersBase.indexOf(manufacturer), editedManufacturer);
                    manufacturersBase.remove(manufacturer);
                    edited = true;
                    break;
                }
            }
            if (edited){
                parser.writeSplitManufacturersBase(manufacturersBase);
            } else {
                menu.displayErrorMessage("No item to edit");
            }
        } catch (Exception e){
            menu.displayErrorMessage(String.valueOf(e));
        }
        return edited;
    }

}
