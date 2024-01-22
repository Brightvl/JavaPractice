package tests.toys_shop.model;


import tests.toys_shop.model.fileManage.BinSerialization;
import tests.toys_shop.model.fileManage.interfaces.Loadable;
import tests.toys_shop.model.fileManage.interfaces.Savable;
import tests.toys_shop.model.shop.ToyShop;
import tests.toys_shop.model.shop.goods.Toy;
import tests.toys_shop.model.shop.raffle.RaffleToys;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Класс ServiceToyShop представляет сервис игрушечного магазина.
 * Он управляет списком доступных игрушек, их добавлением, розыгрышем и сохранением в файл.
 * Реализует интерфейс Command и вызывает соответствующий метод в ConsoleUI для розыгрыша игрушки.
 */
public class ServiceToyShop {
    private ToyShop toyShop;
    RaffleToys raffleToys;
    private Loadable loadable;
    private String filePath;

    /**
     * Конструктор класса ServiceToyShop инициализирует объекты магазина, розыгрыша и управления файлами.
     */
    public ServiceToyShop() {
        this.toyShop = null;
        this.loadable = new BinSerialization(null);
        this.filePath = null;
        this.raffleToys = null;
    }

    /**
     * Загружает данные об игрушках из файла с использованием сериализации.
     * @param filePath
     */
    public void loadFile(String filePath) {
        this.filePath = filePath;
        this.loadable.setFilePath(filePath);
        this.toyShop = (ToyShop) loadable.loadFile();
        this.raffleToys = new RaffleToys(toyShop.getAllToys());
        Toy.setCounter(checkMaxId(toyShop.getAllToys())+1);
    }

    /**
     * Метод возвращает список всех доступных игрушек из магазина.
     * @return
     */
    public ArrayList<Toy> getAllToys() {
        return toyShop.getAllToys();
    }

    private int checkMaxId(ArrayList<Toy> toysList) {
        return toysList.stream()
                .mapToInt(Toy::getId) // Преобразуем каждый Toy в его id
                .max() // Находим максимальное значение id
                .orElse(0); // Если список пустой, вернуть 0
    }

    /**
     * Метод добавляет новую игрушку в магазин.
     * @param nameToy
     * @param quantity
     * @param dropFrequency
     */
    public void addToy(String nameToy, int quantity, int dropFrequency) {
        Toy toy = new Toy(nameToy, quantity, dropFrequency);
        toyShop.add(toy);
        raffleToys.addToy(toy);
    }

    /**
     * Метод устанавливает вес (частоту выпадения) игрушки из розыгрыша.
     * @param nameToy
     * @param weight
     * @return
     */
    public int setWeightToy(String nameToy, int weight) {
        try {
            getToy(nameToy).setWeight(weight);
            return 0;
        }
        catch (Exception e) {
            return -1;
        }
    }

    /**
     * Метод возвращает игрушку по её названию.
     * @param nameToy
     * @return
     */
    public Toy getToy(String nameToy) {
        return getAllToys().stream()
                .filter(toy -> toy.getName().equalsIgnoreCase(nameToy))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод выполняет розыгрыш игрушки и возвращает выигранную игрушку.
     * @return
     */
    public Toy raffleToy() {
        return raffleToys.raffleToy();
    }

    /**
     *  Метод saveWinnerToy сохраняет список выигранных игрушек в файл.
     * @param toyList
     * @param filePath
     */
    public void saveWinnerToy(ArrayList<Toy> toyList, String filePath) {
        Savable save = new BinSerialization(filePath);
        save.saveFile(toyList);
    }

    public PriorityQueue<Toy> getToysQueue() {
        return raffleToys.getToysQueue();
    }

    public int raffleListSize() {
        return raffleToys.raffleListSize();
    }
}

