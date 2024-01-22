package oop.view.consoleUI.menu.allRecordsMenu;


import oop.view.consoleUI.ConsoleUI;
import oop.view.consoleUI.menu.Menu;
import oop.view.consoleUI.menu.allRecordsMenu.commands.ShowAllRecord;
import oop.view.consoleUI.menu.allRecordsMenu.commands.SortedTree;
import oop.view.consoleUI.menu.mainMenu.commands.GetRecord;
import oop.view.consoleUI.menu.mainMenu.commands.ReturnBack;


import java.util.Arrays;

public class AllRecordsMenu extends Menu {
    public AllRecordsMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new ShowAllRecord(consoleUI),
                new GetRecord(consoleUI),
                new SortedTree(consoleUI),
                new ReturnBack(consoleUI)));
    }


}
