package tests.toys_shop.view.consoleUi.menu.commands;


import tests.toys_shop.view.consoleUi.ConsoleUI;
import view.consoleUi.menu.commands.interfaces.Command;

/**
 * Класс RaffleToys представляет команду для розыгрыша игрушки.
 */
public class RaffleToys implements Command {

    private ConsoleUI consoleUi;

    public RaffleToys(ConsoleUI consoleUi) {
        this.consoleUi = consoleUi;
    }

    @Override
    public String getDescription() {
        return "Розыгрыш игрушки";
    }

    @Override
    public void execute() {
        consoleUi.raffleToys();
    }
}
