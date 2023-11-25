package final_test_nursery.registerAnimalApp.view.consoleUi.menu.commands;


import final_test_nursery.registerAnimalApp.view.consoleUi.ConsoleUI;
import final_test_nursery.registerAnimalApp.view.consoleUi.menu.commands.interfaces.Command;

public class ShowRegister implements Command {

    private ConsoleUI consoleUI;

    public ShowRegister(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Отобразить реестр";
    }

    @Override
    public void execute() { consoleUI.ShowRegister();

    }
}
