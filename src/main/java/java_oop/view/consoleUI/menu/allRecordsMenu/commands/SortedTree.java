package java_oop.view.consoleUI.menu.allRecordsMenu.commands;


import java_oop.view.consoleUI.ConsoleUI;
import java_oop.view.consoleUI.menu.mainMenu.commands.Command;


public class SortedTree implements Command {
    ConsoleUI consoleUI;

    public SortedTree(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Отсортировать древо";
    }

    @Override
    public void execute() {
        consoleUI.runSortingMenu();
    }
}
