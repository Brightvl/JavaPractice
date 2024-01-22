package tests.toys_shop;


import tests.toys_shop.presenter.Presenter;
import tests.toys_shop.view.consoleUi.ConsoleUI;

/**
 * ToyShopApp - это основной класс, представляющий точку входа в приложение игрушечного магазина.
 * Он инициализирует необходимые компоненты и запускает ConsoleUI для взаимодействия с пользователем.
 */
public class ToyShopApp {
    public static void main(String[] args) {

//        ToyShop toyShop = new ToyShop();
//        toyShop.add(new Toy("Мяч", 20, 5));
//        toyShop.add(new Toy("Кукла", 30, 8));
//        toyShop.add(new Toy("Конструктор", 50, 10));
//        toyShop.add(new Toy("Машинка", 50, 10));
//        toyShop.add(new Toy("Погремушка", 50, 10));
//        toyShop.add(new Toy("Мишка", 50, 10));
//        toyShop.add(new Toy("Пирамидка", 50, 10));
//        toyShop.add(new Toy("Рогатка", 50, 10));
//        toyShop.add(new Toy("Мозайка", 50, 10));
//
//        BinSerialization binSerialization = new BinSerialization("src/main/java/model/shop/goods/data/toys.bin");
//        binSerialization.saveFile(toyShop);

        ConsoleUI consoleUi = new ConsoleUI();
        Presenter presenter = new Presenter();
        consoleUi.setPresenter(presenter);

        consoleUi.runProgram();

    }
}

