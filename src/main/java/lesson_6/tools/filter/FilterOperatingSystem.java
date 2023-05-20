package lesson_6.tools.filter;

import lesson_6.goods.Laptop;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static lesson_6.tools.filter.CheckFilters.newSetLaptop;

public class FilterOperatingSystem extends Filter {
    protected static boolean osSelected = false;
    protected static String osName = "";


    /**
     * Множество содержащее совпадение по ОС
     */
    protected static Set<Laptop> setOs = new HashSet<>();

    /**
     * Метод меняет положение выбранного фильтра.
     * @param osName
     */
    protected static void filterOsSelection(String osName) {
        osSelected = !osSelected;
        if (osSelected) {
            FilterOperatingSystem.osName = osName;
        } else {
            osSelected = false;
            System.out.println("Filter removed");
        }
    }

    /**
     * Добавляет значения в множество с операционными системами, если фильтр включен
     * @param laptopSet
     */
    protected static void addOSAFilter(Set<Laptop> laptopSet) {
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

    /**
     * Удаляет значения из множества с операционными системами, если фильтр отключен
     * @param laptopSet
     */
    protected static void removeOSFilter(Set<Laptop> laptopSet) {
         laptopSet.remove()
    }
}


