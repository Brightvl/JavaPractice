package oop.view.consoleUI.menu.mainMenu.commands;


import oop.view.consoleUI.ConsoleUI;

public class RunEndMenu implements Command {

    ConsoleUI consoleUI;

    public RunEndMenu(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Завершить программу";
    }

    @Override
    public void execute() {
        consoleUI.runEndMenu();
    }
}
