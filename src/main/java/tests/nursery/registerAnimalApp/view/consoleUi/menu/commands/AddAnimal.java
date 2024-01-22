package tests.nursery.registerAnimalApp.view.consoleUi.menu.commands;


import tests.nursery.registerAnimalApp.view.consoleUi.ConsoleUI;
import tests.nursery.registerAnimalApp.view.consoleUi.menu.commands.interfaces.Command;

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
