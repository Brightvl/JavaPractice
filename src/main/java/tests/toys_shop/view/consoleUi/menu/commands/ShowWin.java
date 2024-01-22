package tests.toys_shop.view.consoleUi.menu.commands;


import tests.toys_shop.view.consoleUi.ConsoleUI;
import view.consoleUi.menu.commands.interfaces.Command;

/**
 * Класс ShowWin представляет команду для показа выигранных игрушек.
 */
public class ShowWin implements Command {

    ConsoleUI consoleUI;

    public ShowWin(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }


    /**
     * @return описание команды для пункта меню
     */
    @Override
    public String getDescription() {
        return "Что я выиграл?";
    }

    /**
     * Метод execute вызывает метод в ConsoleUI для отображения выигранных игрушек.
     */
    @Override
    public void execute() {
        consoleUI.ShowWin();
    }
}
