package final_tests.nursery.registerAnimalApp.view.consoleUi.menu.typesMenu;



import final_tests.nursery.registerAnimalApp.view.consoleUi.ConsoleUI;
import final_tests.nursery.registerAnimalApp.view.consoleUi.interactionConsole.ConsoleReader;
import final_tests.nursery.registerAnimalApp.view.consoleUi.menu.Menu;
import final_tests.nursery.registerAnimalApp.view.consoleUi.menu.commands.BackMenu;
import final_tests.nursery.registerAnimalApp.view.consoleUi.menu.commands.LearnCommand;
import final_tests.nursery.registerAnimalApp.view.consoleUi.menu.commands.ShowAnimalCommand;
import final_tests.nursery.registerAnimalApp.view.consoleUi.menu.commands.interfaces.MenuCloser;

import java.util.ArrayList;


public class AnimalMenu extends Menu implements MenuCloser {
    ConsoleUI consoleUI;
    private boolean isRunning;
    ConsoleReader consoleReader;
    String typeAnimal;
    String nameAnimal;

    public AnimalMenu(ConsoleUI consoleUI, String typeAnimal, String nameAnimal) {
        super(new ArrayList());
        this.consoleUI = consoleUI;
        this.isRunning = true;
        consoleReader = new ConsoleReader();
        initCommands();
        this.typeAnimal = typeAnimal;
        this.nameAnimal = nameAnimal;
    }

    private void initCommands() {
        addCommand(new ShowAnimalCommand(consoleUI));
        addCommand(new LearnCommand(consoleUI));
        addCommand(new BackMenu(this));
    }



    @Override
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override
    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void closeMenu() {
        setRunning(false);
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }


}
