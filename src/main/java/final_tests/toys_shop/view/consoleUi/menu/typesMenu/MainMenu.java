package final_tests.toys_shop.view.consoleUi.menu.typesMenu;


import final_tests.toys_shop.view.consoleUi.ConsoleUI;
import final_tests.toys_shop.view.consoleUi.menu.Menu;
import final_tests.toys_shop.view.consoleUi.menu.commands.AddToy;
import final_tests.toys_shop.view.consoleUi.menu.commands.CloseProgram;
import final_tests.toys_shop.view.consoleUi.menu.commands.ShowToys;


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
        addCommand(new ToyRaffleMenu(consoleUI));
        addCommand(new AddToy(consoleUI));
        addCommand(new ShowToys(consoleUI));
        addCommand(new OptionsMenu(consoleUI));
        addCommand(new CloseProgram(consoleUI));
    }


    public void setRunning(boolean running) {
        this.isRunning = running;
    }


    public boolean isRunning() {
        return this.isRunning;
    }
}
