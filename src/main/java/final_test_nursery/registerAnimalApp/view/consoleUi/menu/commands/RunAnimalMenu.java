package final_test_nursery.registerAnimalApp.view.consoleUi.menu.commands;


import final_test_nursery.registerAnimalApp.view.consoleUi.ConsoleUI;
import final_test_nursery.registerAnimalApp.view.consoleUi.menu.commands.interfaces.Command;

public class RunAnimalMenu implements Command {

    private ConsoleUI consoleUI;

    public RunAnimalMenu(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Выбрать животное";
    }

    @Override
    public void execute() {
        consoleUI.runAnimalMenu();
    }

}
