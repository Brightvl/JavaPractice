package oop.view.consoleUI.menu.sortingMenu;



import oop.view.consoleUI.ConsoleUI;
import oop.view.consoleUI.menu.Menu;
import oop.view.consoleUI.menu.allRecordsMenu.commands.ShowAllRecord;
import oop.view.consoleUI.menu.mainMenu.commands.GetRecord;
import oop.view.consoleUI.menu.mainMenu.commands.ReturnBack;
import oop.view.consoleUI.menu.sortingMenu.commands.SortByAlphabeticalOrder;
import oop.view.consoleUI.menu.sortingMenu.commands.SortByDateBirth;
import oop.view.consoleUI.menu.sortingMenu.commands.SortByNameLength;

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
