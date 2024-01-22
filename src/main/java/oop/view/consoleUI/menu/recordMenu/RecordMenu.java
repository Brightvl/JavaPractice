package oop.view.consoleUI.menu.recordMenu;


import oop.model.members.Member;
import oop.view.consoleUI.ConsoleUI;
import oop.view.consoleUI.menu.Menu;
import oop.view.consoleUI.menu.mainMenu.commands.ReturnBack;
import oop.view.consoleUI.menu.recordMenu.commands.GetChildren;
import oop.view.consoleUI.menu.recordMenu.commands.GetParents;

import java.util.Arrays;

public class RecordMenu extends Menu {
    Member member;

    public RecordMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new GetChildren(consoleUI),
                new GetParents(consoleUI),
                new ReturnBack(consoleUI)));
        member = null;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
