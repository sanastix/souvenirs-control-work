package org.example;

import org.example.commands.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandListener {

    private final AddSouvenirCommand addSouvenirCommand;
    private final AddManufacturerCommand addManufacturerCommand;
    private final EditSouvenirCommand editSouvenirCommand;
    private final EditManufacturerCommand editManufacturerCommand;
    private final RemoveSouvenirCommand removeSouvenirCommand;
    private final RemoveManufacturerCommand removeManufacturerCommand;

    private Menu menu;

    public CommandListener(AddSouvenirCommand addSouvenirCommand, AddManufacturerCommand addManufacturerCommand, EditSouvenirCommand editSouvenirCommand, EditManufacturerCommand editManufacturerCommand, RemoveSouvenirCommand removeSouvenirCommand, RemoveManufacturerCommand removeManufacturerCommand, Menu menu) {
        this.addSouvenirCommand = addSouvenirCommand;
        this.addManufacturerCommand = addManufacturerCommand;
        this.editSouvenirCommand = editSouvenirCommand;
        this.editManufacturerCommand = editManufacturerCommand;
        this.removeSouvenirCommand = removeSouvenirCommand;
        this.removeManufacturerCommand = removeManufacturerCommand;
        this.menu = menu;

        this.menu.addAddSouvenirListener(new AddSouvenirListener());
        this.menu.addAddManufacturerListener(new AddManufacturerListener());
        this.menu.addEditSouvenirListener(new EditSouvenirListener());
        this.menu.addEditManufacturerListener(new EditManufacturerListener());
        this.menu.addRemoveSouvenirListener(new RemoveSouvenirListener());
        this.menu.addRemoveManufacturerListener(new RemoveManufacturerListener());
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

    class RemoveManufacturerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (removeManufacturerCommand.execute()){
                menu.displayResultMessage("Manufacturer and its souvenirs removed");
            } else {
                menu.displayErrorMessage("Removing error");
            }
        }
    }

}
