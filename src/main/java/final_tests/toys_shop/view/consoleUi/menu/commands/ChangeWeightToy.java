package final_tests.toys_shop.view.consoleUi.menu.commands;


import final_tests.toys_shop.view.consoleUi.ConsoleUI;
import view.consoleUi.menu.commands.interfaces.Command;

/**
 * Класс ChangeWeightToy представляет команду для изменения частоты выпадения игрушки.
 */
public class ChangeWeightToy implements Command {
    private ConsoleUI consoleUI;

    public ChangeWeightToy(ConsoleUI consoleUi) {
        this.consoleUI = consoleUi;
    }

    @Override
    public String getDescription() {
        return "Изменить частоту выпадения игрушки";
    }

    @Override
    public void execute() {
        consoleUI.setWeightToy();
    }
}
