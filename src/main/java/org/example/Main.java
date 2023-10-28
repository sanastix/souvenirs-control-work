package org.example;

import org.example.commands.*;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        AddSouvenirCommand addS = new AddSouvenirCommand(menu);
        AddManufacturerCommand addM = new AddManufacturerCommand(menu);
        EditSouvenirCommand editS = new EditSouvenirCommand(menu);
        EditManufacturerCommand editM = new EditManufacturerCommand(menu);
        RemoveSouvenirCommand removeS = new RemoveSouvenirCommand(menu);
        RemoveManufacturerCommand removeM = new RemoveManufacturerCommand(menu);
        RemoveManufacturerWithItsSouvenirsCommand removeManufacturerWithItsSouvenirsCommand = new RemoveManufacturerWithItsSouvenirsCommand(menu);

        CommandListener controller = new CommandListener(addS, addM, editS, editM, removeS, removeM, removeManufacturerWithItsSouvenirsCommand, menu);

        menu.init();

    }
}