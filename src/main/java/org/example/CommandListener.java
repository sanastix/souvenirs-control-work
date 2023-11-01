package org.example;

import org.example.commands.*;
import org.example.filters.*;
import org.example.menu.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandListener {

    private final AddSouvenirCommand addSouvenirCommand;
    private final AddManufacturerCommand addManufacturerCommand;
    private final EditSouvenirCommand editSouvenirCommand;
    private final EditManufacturerCommand editManufacturerCommand;
    private final RemoveSouvenirCommand removeSouvenirCommand;
    private final RemoveManufacturerCommand removeManufacturerCommand;
    private final RemoveManufacturerWithItsSouvenirsCommand removeManufacturerWithItsSouvenirsCommand;
    private final ShowAllSouvenirs showAllSouvenirs;
    private final ShowAllManufacturers showAllManufacturers;
    private final Menu menu;
    private final SouvenirFilter souvenirFilter;
    private final ManufacturerFilter manufacturerFilter;


    public CommandListener(AddSouvenirCommand addSouvenirCommand, AddManufacturerCommand addManufacturerCommand, EditSouvenirCommand editSouvenirCommand, EditManufacturerCommand editManufacturerCommand, RemoveSouvenirCommand removeSouvenirCommand, RemoveManufacturerCommand removeManufacturerCommand, RemoveManufacturerWithItsSouvenirsCommand removeManufacturerWithItsSouvenirsCommand, Menu menu, ShowAllSouvenirs showAllSouvenirs, ShowAllManufacturers showAllManufacturers, SouvenirFilter souvenirFilter, ManufacturerFilter manufacturerFilter) {
        this.addSouvenirCommand = addSouvenirCommand;
        this.addManufacturerCommand = addManufacturerCommand;
        this.editSouvenirCommand = editSouvenirCommand;
        this.editManufacturerCommand = editManufacturerCommand;
        this.removeSouvenirCommand = removeSouvenirCommand;
        this.removeManufacturerCommand = removeManufacturerCommand;
        this.removeManufacturerWithItsSouvenirsCommand = removeManufacturerWithItsSouvenirsCommand;
        this.showAllSouvenirs = showAllSouvenirs;
        this.showAllManufacturers = showAllManufacturers;
        this.souvenirFilter = souvenirFilter;
        this.manufacturerFilter = manufacturerFilter;

        this.menu = menu;

        this.menu.addAddSouvenirListener(new AddSouvenirListener());
        this.menu.addAddManufacturerListener(new AddManufacturerListener());
        this.menu.addEditSouvenirListener(new EditSouvenirListener());
        this.menu.addEditManufacturerListener(new EditManufacturerListener());
        this.menu.addRemoveSouvenirListener(new RemoveSouvenirListener());
        this.menu.addRemoveManufacturerListener(new RemoveManufacturerListener());
        this.menu.addYesRemoveManListener(new YesRemoveManListener());
        this.menu.addNoRemoveManListener(new NoRemoveManListener());
        this.menu.addShowAllSouvenirsListener(new ShowAllSouvenirsListener());
        this.menu.addShowAllManufacturersListener(new ShowAllManufacturersListener());
        this.menu.addFilterSouvenirsListener(new FilterSouvenirsListener());
        this.menu.addFilterManufacturersListener(new FilterManufacturersListener());
    }

    class AddSouvenirListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (addSouvenirCommand.execute()) {
                menu.displayResultMessage("Souvenir added");
            } else {
                menu.displayErrorMessage("Adding error");
            }
        }
    }

    class AddManufacturerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (addManufacturerCommand.execute()) {
                menu.displayResultMessage("Manufacturer added");
            } else {
                menu.displayErrorMessage("Adding error");
            }
        }
    }

    class EditSouvenirListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (editSouvenirCommand.execute()) {
                menu.displayResultMessage("Souvenir edited");
            } else {
                menu.displayErrorMessage("Editing error");
            }
        }
    }

    class EditManufacturerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (editManufacturerCommand.execute()) {
                menu.displayResultMessage("Manufacturer edited");
            } else {
                menu.displayErrorMessage("Editing error");
            }
        }
    }

    class RemoveSouvenirListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (removeSouvenirCommand.execute()){
                menu.displayResultMessage("Souvenir removed");
            } else {
                menu.displayErrorMessage("Removing error");
            }
        }
    }

    class YesRemoveManListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (removeManufacturerWithItsSouvenirsCommand.execute()) {
                menu.displayResultMessage("Manufacturer and its souvenirs removed");
            } else {
                menu.displayErrorMessage("Removing error");
            }
        }
    }

    class NoRemoveManListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (removeManufacturerCommand.execute()) {
                menu.displayResultMessage("Manufacturer removed");
            } else {
                menu.displayErrorMessage("Removing error");
            }
        }
    }

    class RemoveManufacturerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (menu.getManufacturer() != null){
                menu.removeManWithItems();
            }
        }
    }

    class ShowAllSouvenirsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            showAllSouvenirs.show();
        }
    }

    class ShowAllManufacturersListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            showAllManufacturers.show();
        }
    }

    class FilterSouvenirsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
/*            SouvenirFilter souvenirFilters = new SouvenirFilter(
                    menu.enterSName.getText(),
                    menu.sByManBox.getSelectedItem().toString(),
                    menu.sByCountryBox.getSelectedItem().toString(),
                    Integer.parseInt(menu.sByYearBox.getSelectedItem().toString()),
                    Double.parseDouble(menu.minSPrice.getText()),
                    Double.parseDouble(menu.maxSPrice.getText())
            );

            List<List<String>> filteredSouvenirs = dataFilter.filterSouvenirs(parser.readSplitSouvenirsBase(), souvenirFilters);

            TableModel model = new TableModel(filteredSouvenirs, souvenirColumnNames);*/

        }

    }

    class FilterManufacturersListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
/*            ManufacturerFilter manufacturerFilters = new ManufacturerFilter(
                    menu.enterMName.getText(),
                    menu.mByCountryBox.getSelectedItem().toString(),
                    Double.parseDouble(menu.minMPrice.getText()),
                    Double.parseDouble(menu.maxMPrice.getText())
            );

            List<List<String>> filteredManufacturers = dataFilter.filterManufacturers(parser.readSplitManufacturersBase(), manufacturerFilters);

            // Оновлення JTable з фільтрованими виробниками
            TableModel model = new TableModel(filteredManufacturers, manufacturerColumnNames);
            //table.setModel(model);*/
        }
    }
}
