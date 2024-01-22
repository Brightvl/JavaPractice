package tests.toys_shop.view.consoleUi.menu.commands;


import tests.toys_shop.view.consoleUi.ConsoleUI;
import view.consoleUi.menu.commands.interfaces.Command;

/**
 * Класс ShowToys представляет команду для показа всех видов игрушек.
 */
public class ShowToys implements Command {
    private ConsoleUI consoleUi;

    public ShowToys(ConsoleUI consoleUi) {
        this.consoleUi = consoleUi;
    }

    @Override
    public String getDescription() {
        return "Список игрушек в магазине";
    }

    @Override
    public void execute() {
        consoleUi.showAllToys();
    }
}
