package org.example.commands;

import org.example.FileParser;
import org.example.Menu;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RemoveManufacturerWithItsSouvenirsCommand extends Command {

    private final FileParser parser = new FileParser(menu);

    public RemoveManufacturerWithItsSouvenirsCommand(Menu menu) {
        super(menu);
    }

    @Override
    public boolean execute() {
        String manufacturer = menu.getManufacturer();
        List<String> manufacturerToRemove = Arrays.stream(manufacturer.split(":")).toList();
        List<String> manufacturersBase = parser.readManufacturersBase();
        List<List<String>> souvenirsBase = parser.readSplitSouvenirsBase();
        boolean removed = false;
        try {
            Iterator<List<String>> souvenirIterator = souvenirsBase.iterator();
            while (souvenirIterator.hasNext()) {
                List<String> souvenir = souvenirIterator.next();
                if (souvenir.get(2).equals(manufacturerToRemove.get(1))) {
                    souvenirIterator.remove();
                    removed = true;
                }
            }

            if (removed) {
                Iterator<String> manIterator = manufacturersBase.iterator();
                while (manIterator.hasNext()) {
                    String man = manIterator.next();
                    if (man.equals(manufacturer)) {
                        manIterator.remove();
                        break;
                    }
                }
                //manufacturersBase.remove(manufacturer);
                parser.writeSplitSouvenirsBase(souvenirsBase);
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
