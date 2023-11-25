package java_oop.view.consoleUI.menu.endMenu;


import java_oop.view.consoleUI.ConsoleUI;
import java_oop.view.consoleUI.menu.Menu;
import java_oop.view.consoleUI.menu.endMenu.commands.Finish;
import java_oop.view.consoleUI.menu.endMenu.commands.Save;
import java_oop.view.consoleUI.menu.mainMenu.commands.ReturnBack;


import java.util.Arrays;

public class EndMenu extends Menu {
    public EndMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new ReturnBack(consoleUI),
                new Save(consoleUI),
                new Finish(consoleUI)));
    }
}
