package lesson_6.tools.filter.сategoriesLaptop;

import lesson_6.goods.laptop.Laptop;
import lesson_6.tools.filter.Filter;

import java.util.HashSet;
import java.util.Set;

import static lesson_6.tools.filter.FilterInfo.infoFilterLaptop;

public class FilterReleaseYear extends Filter {

    public static boolean releaseYearSelected = false;
    public static String releaseYear = "";


    /**
     * Все даты изготовления
     */
    public static Set<String> allSetYear = new HashSet<>();
    /**
     * Множество содержащее совпадение по год изготовления
     */
    public static Set<Laptop> setYear = new HashSet<>();

    /**
     * Вывод в консоль дополнительной информации о фильтре дат
     */
    public static void displayFiltersYear(Set<Laptop> laptopSet) {
        for (Laptop laptop : laptopSet) {
            allSetYear.add(laptop.getReleaseYear());
        }
    }

    /**
     * Метод меняет положение выбранного фильтра.
     */
    public static void switchingYearSelected(Set<Laptop> laptopSet) {
        if (!releaseYearSelected) {
            releaseYearSelected = true;
            displayFiltersYear(laptopSet); // отобразил на экран по фильтру
            infoFilterLaptop();
            System.out.println("Введите один из предложенных фильтров");
            releaseYear = scanner.nextLine();
            addYearFilter(laptopSet);
            allSetYear.clear();

        } else {
            releaseYearSelected = false;
            releaseYear = "";
            allSetYear.clear();
            setYear.clear();
        }
    }

    /**
     * Добавляет значения в множество с операционными системами, если фильтр включен
     */
    protected static void addYearFilter(Set<Laptop> laptopSet) {
        if (releaseYearSelected) {
            for (Laptop element : laptopSet
            ) {
                try {
                    if (element.getOperatingSystem().equalsIgnoreCase(releaseYear))
                        setYear.add(element);
                } catch (NullPointerException e) {
                }
            }
        }
    }
}
