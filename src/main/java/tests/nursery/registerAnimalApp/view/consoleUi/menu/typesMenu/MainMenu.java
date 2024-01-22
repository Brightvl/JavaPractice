package tests.nursery.registerAnimalApp.view.consoleUi.menu.typesMenu;


import tests.nursery.registerAnimalApp.view.consoleUi.ConsoleUI;
import tests.nursery.registerAnimalApp.view.consoleUi.menu.Menu;
import tests.nursery.registerAnimalApp.view.consoleUi.menu.commands.AddAnimal;
import tests.nursery.registerAnimalApp.view.consoleUi.menu.commands.CloseProgram;
import tests.nursery.registerAnimalApp.view.consoleUi.menu.commands.RunAnimalMenu;
import tests.nursery.registerAnimalApp.view.consoleUi.menu.commands.ShowRegister;

import java.util.ArrayList;

/**
 * MainMenu представляет главное меню приложения игрушечного магазина.
 * Он наследует класс Menu и предоставляет команды для взаимодействия с пользователем.
 */
public class MainMenu extends Menu {
    private boolean isRunning;
    ConsoleUI consoleUI;

    public MainMenu(ConsoleUI consoleUI) {
        super(new ArrayList());
        this.isRunning = true;
        this.consoleUI = consoleUI;
        initCommands();
    }

    private void initCommands() {

        addCommand(new ShowRegister(consoleUI));
        addCommand(new AddAnimal(consoleUI));
        addCommand(new RunAnimalMenu(consoleUI));
        addCommand(new CloseProgram(consoleUI));
    }


    public void setRunning(boolean running) {
        this.isRunning = running;
    }


    public boolean isRunning() {
        return this.isRunning;
    }
}
