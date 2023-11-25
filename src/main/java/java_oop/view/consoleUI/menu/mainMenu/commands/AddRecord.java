package java_oop.view.consoleUI.menu.mainMenu.commands;


import java_oop.view.consoleUI.ConsoleUI;

/**
 * Класс AddRecord представляет команду добавления записи в древо в меню консольного пользовательского интерфейса (UI).
 * Реализует интерфейс Sortedable.
 */
public class AddRecord implements Command {
    private ConsoleUI consoleUI;

    /**
     * Создает новый объект AddRecord.
     *
     * @param consoleUI объект ConsoleUI, используемый для добавления записи в древо
     */
    public AddRecord(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Добавить запись в древо";
    }

    @Override
    public void execute() {
        consoleUI.addRecord();
    }
}
