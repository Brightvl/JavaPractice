package java_oop.view.consoleUI.menu.sortingMenu;



import java_oop.view.consoleUI.ConsoleUI;
import java_oop.view.consoleUI.menu.Menu;
import java_oop.view.consoleUI.menu.allRecordsMenu.commands.ShowAllRecord;
import java_oop.view.consoleUI.menu.mainMenu.commands.GetRecord;
import java_oop.view.consoleUI.menu.mainMenu.commands.ReturnBack;
import java_oop.view.consoleUI.menu.sortingMenu.commands.SortByAlphabeticalOrder;
import java_oop.view.consoleUI.menu.sortingMenu.commands.SortByDateBirth;
import java_oop.view.consoleUI.menu.sortingMenu.commands.SortByNameLength;

import java.util.Arrays;
public class SortingMenu extends Menu {
    public SortingMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new ShowAllRecord(consoleUI),
                new GetRecord(consoleUI),
                new SortByAlphabeticalOrder(consoleUI),
                new SortByDateBirth(consoleUI),
                new SortByNameLength(consoleUI),
                new ReturnBack(consoleUI)));
    }


}
