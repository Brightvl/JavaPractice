package tests.toys_shop.view.consoleUi.menu.commands;



import tests.toys_shop.view.consoleUi.ConsoleUI;
import view.consoleUi.menu.commands.interfaces.Command;

/**
 * Класс CloseProgram представляет команду выхода из программы с сохранением в меню консольного пользовательского интерфейса (UI).
 */
public class CloseProgram implements Command {

    private ConsoleUI consoleUI;

    /**
     * Создает новый объект CloseProgram.
     * @param consoleUI объект ConsoleUI, используемый для завершения программы с сохранением
     */
    public CloseProgram(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Выйти из программы";
    }

    @Override
    public void execute() {
        consoleUI.closeProgram();
    }
}
