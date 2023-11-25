package java_oop.view.consoleUI.menu.mainMenu.commands;


import java_oop.view.consoleUI.ConsoleUI;

/**
 * Класс GetRecord представляет команду получения записи из древа в меню консольного пользовательского интерфейса (UI).
 * Реализует интерфейс Sortedable.
 */
public class GetRecord implements Command {
    private ConsoleUI consoleUI;

    /**
     * Создает новый объект GetRecord.
     *
     * @param consoleUI объект ConsoleUI, используемый для получения записи из древа
     */
    public GetRecord(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Получить запись из древа";
    }

    @Override
    public void execute() {
        consoleUI.runRecordMenu(consoleUI.getRecord());
    }
}
