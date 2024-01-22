package tests.toys_shop.view.consoleUi;


import tests.toys_shop.model.shop.goods.Toy;
import tests.toys_shop.presenter.Presenter;
import tests.toys_shop.view.View;
import tests.toys_shop.view.consoleUi.interactionConsole.ConsoleReader;
import tests.toys_shop.view.consoleUi.menu.typesMenu.MainMenu;


import java.util.ArrayList;

/**
 * ConsoleUI представляет консольный пользовательский интерфейс для приложения игрушечного магазина.
 * Он реализует интерфейс View и предоставляет методы для взаимодействия с пользователем через консоль.
 */
public class ConsoleUI implements View {

    private Presenter presenter;
    private ConsoleReader consoleReader;
    private MainMenu mainMenu;

    public ConsoleUI() {
        this.consoleReader = new ConsoleReader();
        this.presenter = new Presenter();
        this.mainMenu = new MainMenu(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Метод runMainMenu() запускает главное меню.
     * Пользователю выводится список пунктов меню, и программа ожидает ввода выбранного пункта.
     * После выбора пункта меню происходит выполнение соответствующей команды.
     */
    @Override
    public void runProgram() {
        presenter.loadToys();
        runMainMenu();
    }

    private void runMainMenu() {
        while (mainMenu.isRunning()) {
            consoleReader.println(mainMenu.printMenu());
            String choice = consoleReader.input("Выберите пункт меню: ");
            if (mainMenu.checkInputLineMenu(choice) == -1) {
                consoleReader.println("Ошибка ввода");
                continue;
            }
            mainMenu.execute(Integer.parseInt(choice));
        }
    }


    public void closeProgram() {
        mainMenu.setRunning(false);
    }

    public void raffleToys() {
        presenter.raffleToy();
    }

    public void showAllToys() {
        ArrayList<Toy> allToys = presenter.getAllToys();
        if (allToys.isEmpty()) {
            consoleReader.println("В магазине нет игрушек.");
            return;
        }
        consoleReader.println("Список всех игрушек:");
        consoleReader.printToyInfo();
        for (Toy toy : allToys) {
            consoleReader.println(toy.toString());
        }
    }

    public void addToy() {
        String nameToy = consoleReader.inputln("Введите название");
        try {
            int quantity = Integer.parseInt(consoleReader.inputln("Введите количество"));
            int dropFrequency = Integer.parseInt(consoleReader.inputln("Введите шанс выпадения"));
            presenter.addToy(nameToy, quantity, dropFrequency);
        } catch (NumberFormatException numberFormatException) {
            consoleReader.println("Произошла ошибка");
        }
    }

    public void setWeightToy() {
        String nameToy = consoleReader.inputln("Введите название");
        try {
            int dropFrequency = Integer.parseInt(consoleReader.inputln("Введите шанс выпадения"));
            if (presenter.setWeightToy(nameToy, dropFrequency) == 0)
                consoleReader.println("Шанс выпадения изменен");
            else consoleReader.println("Игрушка не найдена");
        } catch (NumberFormatException numberFormatException) {
            consoleReader.println("Ошибка ввода");
        }
    }

    public void ShowWin() {
        ArrayList<Toy> temp = presenter.showWin();
        if (!temp.isEmpty()) {
            consoleReader.printToyInfo();
            for (Toy toy : temp) {
                consoleReader.println(toy.toString());
            }
        } else {
            consoleReader.println("Вы еще ничего не выиграли");
        }
    }

    public void getToysQueue() {
        consoleReader.printToyInfo();
        for (Toy toy : presenter.getToysQueue()) {
            consoleReader.println(toy.toString());
        }
    }

}
