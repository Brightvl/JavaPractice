package tests.nursery.registerAnimalApp.view.consoleUi.menu.commands;


import tests.nursery.registerAnimalApp.view.consoleUi.ConsoleUI;
import tests.nursery.registerAnimalApp.view.consoleUi.menu.commands.interfaces.Command;

public class LearnCommand implements Command {

    private ConsoleUI consoleUI;


    public LearnCommand(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Изучить новую команду";
    }

    @Override
    public void execute() { consoleUI.learnCommand();

    }
}
