package final_test_nursery.registerAnimalApp.view.consoleUi.menu.commands;


import final_test_nursery.registerAnimalApp.view.consoleUi.ConsoleUI;
import final_test_nursery.registerAnimalApp.view.consoleUi.menu.commands.interfaces.Command;

;


public class AddAnimal implements Command {

    private ConsoleUI consoleUI;


    public AddAnimal(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Добавить животное в реестр";
    }

    @Override
    public void execute() { consoleUI.addAnimal();

    }
}
