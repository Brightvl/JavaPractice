package java_oop.view.consoleUI.menu.recordMenu.commands;


import java_oop.view.consoleUI.ConsoleUI;
import java_oop.view.consoleUI.menu.mainMenu.commands.Command;

/**
 * Класс GetParents представляет команду получения родителей человека из дерева в меню консольного пользовательского интерфейса (UI).
 * Реализует интерфейс Sortedable.
 */
public class GetParents implements Command {
    private ConsoleUI consoleUI;

    /**
     * Создает новый объект GetParents.
     *
     * @param consoleUI объект ConsoleUI, используемый для получения родителей человека из дерева
     */
    public GetParents(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Получить родителей человека из дерева";
    }

    @Override
    public void execute() {
        consoleUI.getParents();

    }
}