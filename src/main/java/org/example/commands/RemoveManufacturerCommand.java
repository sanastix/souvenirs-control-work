package org.example.commands;

import org.example.FileParser;
import org.example.menu.Menu;

import java.util.List;

public class RemoveManufacturerCommand extends Command {

    private final FileParser parser = new FileParser(menu);

    public RemoveManufacturerCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        String manufacturerToRemove = menu.getManufacturer();
        List<String> manufacturersBase = parser.readManufacturersBase();
        boolean removed = false;
        try {
            for (String manufacturer : manufacturersBase){
                if (manufacturer.equals(manufacturerToRemove)){
                    manufacturersBase.remove(manufacturer);
                    removed = true;
                    break;
                }
            }
            if (removed) {
                parser.writeManufacturerBase(manufacturersBase);
            } else {
                menu.displayErrorMessage("No item to remove");
            }
        } catch (Exception e){
            menu.displayErrorMessage(String.valueOf(e));
        }
        return removed;
    }
}
