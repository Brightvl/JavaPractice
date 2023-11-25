package final_tests.toys_shop.view.consoleUi.menu.commands;


import final_tests.toys_shop.view.consoleUi.ConsoleUI;
import view.consoleUi.menu.commands.interfaces.Command;

public class ShowRaffledToys implements Command {


    private ConsoleUI consoleUi;

    public ShowRaffledToys(ConsoleUI consoleUi) {
        this.consoleUi = consoleUi;
    }

    @Override
    public String getDescription() {
        return "Список призовых игрушек";
    }

    @Override
    public void execute() {
        consoleUi.getToysQueue();
    }
}


