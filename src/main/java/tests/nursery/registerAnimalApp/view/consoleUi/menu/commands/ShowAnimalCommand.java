package tests.nursery.registerAnimalApp.view.consoleUi.menu.commands;


import tests.nursery.registerAnimalApp.view.consoleUi.ConsoleUI;
import tests.nursery.registerAnimalApp.view.consoleUi.menu.commands.interfaces.Command;

/**
 * Класс CloseProgram представляет команду выхода из программы с сохранением в меню консольного пользовательского интерфейса (UI).
 */
public class ShowAnimalCommand implements Command {

    private ConsoleUI consoleUI;


    public ShowAnimalCommand(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Показать список команд животного";
    }

    @Override
    public void execute() { consoleUI.ShowAnimalCommand();

    }
}
