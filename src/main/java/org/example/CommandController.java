package org.example;

import org.example.commands.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandController {

    private final AddSouvenirCommand addSouvenirCommand;
    private final AddManufacturerCommand addManufacturerCommand;
    private final EditSouvenirCommand editSouvenirCommand;
    private final EditManufacturerCommand editManufacturerCommand;
    private final RemoveSouvenirCommand removeSouvenirCommand;
    private final RemoveManufacturerCommand removeManufacturerCommand;

    private final Menu menu;

    public CommandController(AddSouvenirCommand addSouvenirCommand, AddManufacturerCommand addManufacturerCommand, EditSouvenirCommand editSouvenirCommand, EditManufacturerCommand editManufacturerCommand, RemoveSouvenirCommand removeSouvenirCommand, RemoveManufacturerCommand removeManufacturerCommand, Menu menu) {
        this.addSouvenirCommand = addSouvenirCommand;
        this.addManufacturerCommand = addManufacturerCommand;
        this.editSouvenirCommand = editSouvenirCommand;
        this.editManufacturerCommand = editManufacturerCommand;
        this.removeSouvenirCommand = removeSouvenirCommand;
        this.removeManufacturerCommand = removeManufacturerCommand;
        this.menu = menu;

        this.menu.addAddSouvenirListener(new AddSouvenirListener());
        this.menu.addAddManufacturerListener(new AddManufacturerListener());
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

}
