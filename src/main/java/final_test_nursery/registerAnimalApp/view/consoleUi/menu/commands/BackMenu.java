package final_test_nursery.registerAnimalApp.view.consoleUi.menu.commands;


import final_test_nursery.registerAnimalApp.view.consoleUi.menu.commands.interfaces.Command;
import final_test_nursery.registerAnimalApp.view.consoleUi.menu.commands.interfaces.MenuCloser;

public class BackMenu implements Command {
    private MenuCloser menuToClose;

    public BackMenu(MenuCloser menuToClose) {
        this.menuToClose = menuToClose;
    }

    @Override
    public String getDescription() {
        return "Вернуться назад";
    }

    @Override
    public void execute() {
        menuToClose.closeMenu();
    }
}
