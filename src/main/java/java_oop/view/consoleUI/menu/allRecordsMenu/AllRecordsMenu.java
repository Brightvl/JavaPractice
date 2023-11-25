package java_oop.view.consoleUI.menu.allRecordsMenu;


import java_oop.view.consoleUI.ConsoleUI;
import java_oop.view.consoleUI.menu.Menu;
import java_oop.view.consoleUI.menu.allRecordsMenu.commands.ShowAllRecord;
import java_oop.view.consoleUI.menu.allRecordsMenu.commands.SortedTree;
import java_oop.view.consoleUI.menu.mainMenu.commands.GetRecord;
import java_oop.view.consoleUI.menu.mainMenu.commands.ReturnBack;


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
