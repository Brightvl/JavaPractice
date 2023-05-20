package lesson_6.tools.filter.сategoriesLaptop;

import lesson_6.goods.laptop.Laptop;

import java.util.HashSet;
import java.util.Set;

import static lesson_6.tools.filter.Filter.scanner;
import static lesson_6.tools.filter.FilterInfo.infoFilterLaptop;

public class FilterBrand {

    public static boolean brandSelected = false;
    public static String brandName = "";

    /**
     * Все виды брендов
     */
    public static Set<String> allSetBrands = new HashSet<>();
    /**
     * Множество содержащее совпадение по брендам
     */
    private static Set<Laptop> setBrands = new HashSet<>();

    /**
     * Вывод в консоль дополнительной информации о фильтре брендов
     */
    private static void displayFiltersBrands(Set<Laptop> laptopSet) {
        for (Laptop laptop : laptopSet) {
            allSetBrands.add(laptop.getBrand());
        }
    }

    /**
     * Метод меняет положение выбранного фильтра.
     */
    public static void switchingBrandsSelected(Set<Laptop> laptopSet) {
        if (!brandSelected) {
            brandSelected = true;
            displayFiltersBrands(laptopSet); // отобразил на экран по фильтру
            infoFilterLaptop();
            System.out.println("Введите один из предложенных фильтров");
            brandName = scanner.nextLine();
            addBrandsFilter(laptopSet);
            allSetBrands.clear();

        } else {
            brandSelected = false;
            brandName = "";
            allSetBrands.clear();
            setBrands.clear();
        }
    }

    /**
     * Добавляет значения в множество с операционными системами, если фильтр включен
     */
    private static void addBrandsFilter(Set<Laptop> laptopSet) {
        if (brandSelected) {
            for (Laptop element : laptopSet
            ) {
                try {
                    if (element.getOperatingSystem().equalsIgnoreCase(brandName))
                        setBrands.add(element);
                } catch (NullPointerException e) {
                }
            }
        }
    }
}
