package lesson_6.tools.filter.сategoriesLaptop;

import lesson_6.goods.laptop.Laptop;
import lesson_6.tools.filter.Filter;

import java.util.HashSet;
import java.util.Set;

import static lesson_6.tools.filter.FilterInfo.infoFilterLaptop;

public class FilterOperatingSystem extends Filter {
    public static boolean osSelected = false;
    public static String osName = "";

    /**
     * Все виды ОС
     */
    public static Set<String> allSetOs = new HashSet<>();
    /**
     * Множество содержащее совпадение по ОС
     */
    public static Set<Laptop> setOs = new HashSet<>();

    /**
     * Вывод в консоль дополнительной ифномарции о фильтре ОС
     * @param laptopSet
     */
    public static void displayFiltersOS(Set<Laptop> laptopSet) {
        for (Laptop laptop : laptopSet) {
            allSetOs.add(laptop.getOperatingSystem());
        }
    }

    /**
     * Метод меняет положение выбранного фильтра.
     */
    public static void switchingOsSelected(Set<Laptop> laptopSet) {
        if (!osSelected) {
            osSelected = true;
            displayFiltersOS(laptopSet); // отобразил на экран по фильтру
            infoFilterLaptop();
            System.out.println("Введите один из предложенных фильтров");
            osName = scanner.nextLine();
            addOSFilter(laptopSet);
            allSetOs.clear();

        } else {
            osSelected = false;
            osName = "";
            allSetOs.clear();
            setOs.clear();
        }
    }

    /**
     * Добавляет значения в множество с операционными системами, если фильтр включен
     */
    protected static void addOSFilter(Set<Laptop> laptopSet) {
        if (osSelected) {
            for (Laptop element : laptopSet
            ) {
                try {
                    if (element.getOperatingSystem().equalsIgnoreCase(osName))
                        setOs.add(element);
                } catch (NullPointerException e) {
                }
            }
        }
    }


}


