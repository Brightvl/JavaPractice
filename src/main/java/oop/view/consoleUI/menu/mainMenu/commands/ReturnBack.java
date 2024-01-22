package oop.view.consoleUI.menu.mainMenu.commands;


import oop.view.consoleUI.ConsoleUI;

public class ReturnBack implements Command {

    ConsoleUI consoleUI;

    public ReturnBack(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Вернуться назад";
    }

    @Override
    public void execute() {

    }
}
