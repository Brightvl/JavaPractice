package java_oop.view.consoleUI.menu.mainMenu;


import java_oop.view.consoleUI.ConsoleUI;
import java_oop.view.consoleUI.menu.Menu;
import java_oop.view.consoleUI.menu.mainMenu.commands.AddRecord;
import java_oop.view.consoleUI.menu.mainMenu.commands.GetAllRecord;
import java_oop.view.consoleUI.menu.mainMenu.commands.GetRecord;
import java_oop.view.consoleUI.menu.mainMenu.commands.RunEndMenu;

import java.util.Arrays;

/**
 * Класс MainMenu представляет главное меню консольного пользовательского интерфейса (UI).
 * Содержит список доступных команд и предоставляет методы для выполнения выбранной команды и получения размера меню.
 */
public class MainMenu extends Menu {

    private boolean isRun;

    public MainMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new AddRecord(consoleUI),
                new GetRecord(consoleUI),
                new GetAllRecord(consoleUI),
                new RunEndMenu(consoleUI)));
        this.isRun = true;
    }

    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean run) {
        isRun = run;
    }
}
