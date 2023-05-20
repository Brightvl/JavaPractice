package lesson_6.tools.filter;

import lesson_6.goods.Laptop;

import java.util.*;

import static lesson_6.tools.filter.FilterInfo.infoFilterLaptop;
import static lesson_6.tools.filter.category.FilterBrand.*;
import static lesson_6.tools.filter.category.FilterOperatingSystem.*;
import static lesson_6.tools.filter.category.FilterReleaseYear.*;


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
                    switchingYearSelected(laptopSet);

                }
                //Фильтр по операционке
                case "3" -> {
                    switchingOsSelected(laptopSet);
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
        showSelectedFilterValues(laptopSet);


    }

    private static void showSelectedFilterValues(Set<Laptop> laptopSet) {
        Set<Laptop> result = new HashSet<>();
        if (brandSelected) {
            for (Laptop laptop : laptopSet
            ) {
                if (laptop.getBrand().equalsIgnoreCase(brandName)) {
                    result.add(laptop);
                }
            }
        }
        if (releaseYearSelected) {
            for (Laptop laptop : laptopSet
            ) {
                if (laptop.getReleaseYear().equalsIgnoreCase(releaseYear)) {
                    result.add(laptop);
                }
            }
        }
        if (osSelected) {
            for (Laptop laptop : laptopSet
            ) {
                if (laptop.getOperatingSystem().equalsIgnoreCase(osName)) {
                    result.add(laptop);
                }
            }
        }

        int i = 1;
        for (Laptop out : result
        ) {
            System.out.println(i++ +". " + out);
        }


    }
}

