package oop.view.consoleUI.menu.endMenu;


import oop.view.consoleUI.ConsoleUI;
import oop.view.consoleUI.menu.Menu;
import oop.view.consoleUI.menu.endMenu.commands.Finish;
import oop.view.consoleUI.menu.endMenu.commands.Save;
import oop.view.consoleUI.menu.mainMenu.commands.ReturnBack;


import java.util.Arrays;

public class EndMenu extends Menu {
    public EndMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new ReturnBack(consoleUI),
                new Save(consoleUI),
                new Finish(consoleUI)));
    }
}
