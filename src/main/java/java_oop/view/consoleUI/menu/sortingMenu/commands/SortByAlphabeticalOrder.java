package java_oop.view.consoleUI.menu.sortingMenu.commands;


import java_oop.view.consoleUI.ConsoleUI;
import java_oop.view.consoleUI.menu.mainMenu.commands.Command;

public class SortByAlphabeticalOrder implements Command {

    ConsoleUI consoleUI;

    public SortByAlphabeticalOrder(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }


    @Override
    public String getDescription() {
        return "Отсортировать по именам в алфавитном порядке.";
    }

    @Override
    public void execute() {
        consoleUI.sortByAlphabeticalOrder();

    }
}
