package final_tests.toys_shop.presenter;



import final_tests.toys_shop.model.ServiceToyShop;
import final_tests.toys_shop.model.shop.goods.Toy;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Класс Presenter представляет презентер в архитектуре MVP (Model-View-Presenter).
 * Презентер служит промежуточным звеном между моделью (ServiceToyShop) и пользовательским интерфейсом (ConsoleUI).
 * Он обрабатывает пользовательский ввод и вызывает соответствующие методы в модели для выполнения операций с игрушками.
 */
public class Presenter {

    private ServiceToyShop serviceToyShop;
    ArrayList<Toy> toysWin;


    /**
     * Конструктор класса Presenter инициализирует объекты модели и списка выигранных игрушек.
     */
    public Presenter() {
        this.serviceToyShop = new ServiceToyShop();
        this.toysWin = new ArrayList<>();
    }

    /**
     * Возвращает список всех доступных игрушек из модели.
     * @return
     */
    public ArrayList<Toy> getAllToys() {
        return serviceToyShop.getAllToys();
    }

    /**
     * Загружает данные об игрушках из файла с использованием сериализации.
     */
    public void loadToys() {
        serviceToyShop.loadFile("src/main/java/model/shop/goods/data/toys.bin");
    }

    /**
     * Добавляет новую игрушку в магазин.
     * @param nameToy
     * @param quantity
     * @param dropFrequency
     */
    public void addToy(String nameToy, int quantity, int dropFrequency) {
        serviceToyShop.addToy(nameToy, quantity, dropFrequency);
    }


    /**
     * Метод устанавливает частоту выпадения игрушки из розыгрыша.
     * @param nameToy
     * @param dropFrequency
     * @return
     */
    public int setWeightToy(String nameToy, int dropFrequency) {
        return serviceToyShop.setWeightToy(nameToy, dropFrequency);
    }

    /**
     * Метод выполняет розыгрыш игрушки и возвращает выигранную игрушку.
     * @return
     */
    public Toy raffleToy() {
        Toy prizeToy = serviceToyShop.raffleToy();
        if (prizeToy != null) {
            this.toysWin.add(prizeToy);
            serviceToyShop.saveWinnerToy(toysWin, "src/main/java/model/shop/goods/data/raffleToys.bin");
        }
        return prizeToy;
    }

    public ArrayList<Toy> showWin() {
        return toysWin;
    }

    public PriorityQueue<Toy> getToysQueue() {
        return serviceToyShop.getToysQueue();
    }

    public int raffleListSize() {
        return serviceToyShop.raffleListSize();
    }
}
