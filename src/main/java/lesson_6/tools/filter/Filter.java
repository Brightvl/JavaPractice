package lesson_6.tools.filter;

import lesson_6.goods.Laptop;

import java.util.*;

import static lesson_6.tools.filter.FilterInfo.infoFilterLaptop;
import static lesson_6.tools.filter.category.FilterBrand.switchingBrandsSelected;
import static lesson_6.tools.filter.category.FilterOperatingSystem.*;


public class Filter {

    public static Scanner scanner = new Scanner(System.in);
    private static Set<Laptop> filterSet = new HashSet<>();


    /**
     * Выбор фильтра
     *
     * @param laptopSet
     */
    private static void selectFilter(Set<Laptop> laptopSet) {
        boolean flag = true;
        infoFilterLaptop();
        while (flag) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    switchingBrandsSelected(laptopSet);
                }
                case "2" -> {

                }
                //Фильтр по операционке
                case "3" -> {
                    switchingOsSelected(laptopSet); // применяем фильтр
                }
                case "4" -> {

                    flag = false;
                }
                default -> {
                    System.out.println("Введите корректное значение");
                }

            }
            infoFilterLaptop();
        }

    }


    public static void addFilter(Set<Laptop> laptopSet) {
        selectFilter(laptopSet);


    }

    private static void ShowSelectedFilterValues() {

    }
}

