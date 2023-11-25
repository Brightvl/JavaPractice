package java_oop.view.consoleUI.menu.mainMenu.commands;


import java_oop.view.consoleUI.ConsoleUI;

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
