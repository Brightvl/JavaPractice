package java_oop.view.consoleUI.menu.sortingMenu.commands;


import java_oop.view.consoleUI.ConsoleUI;
import java_oop.view.consoleUI.menu.mainMenu.commands.Command;

public class SortByNameLength implements Command {
    ConsoleUI consoleUI;

    public SortByNameLength(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Отсортировать по длине имени";
    }

    @Override
    public void execute() {
        consoleUI.sortByNameLength();

    }
}
