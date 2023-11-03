package org.example;

import org.example.commands.*;
import org.example.filters.*;
import org.example.menu.Menu;

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
        ShowAllSouvenirs showAllSouvenirs = new ShowAllSouvenirs();
        ShowAllManufacturers showAllManufacturers = new ShowAllManufacturers();
        SouvenirFilter souvenirFilter = new SouvenirFilter(menu);
        ManufacturerFilter manufacturerFilter = new ManufacturerFilter(menu);
        ShowAllDatabase showAllDatabase = new ShowAllDatabase();

        CommandListener controller = new CommandListener(addS, addM, editS, editM, removeS, removeM, removeManufacturerWithItsSouvenirsCommand, menu, showAllSouvenirs, showAllManufacturers, souvenirFilter, manufacturerFilter, showAllDatabase);

        menu.init();

    }
}