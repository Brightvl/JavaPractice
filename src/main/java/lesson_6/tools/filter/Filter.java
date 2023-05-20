package lesson_6.tools.filter;

import lesson_6.goods.laptop.Laptop;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static lesson_6.tools.filter.FilterInfo.viewFilterInfo;
import static lesson_6.tools.filter.сategoriesLaptop.FilterManufacture.*;
import static lesson_6.tools.filter.сategoriesLaptop.FilterCategory.*;
import static lesson_6.tools.filter.сategoriesLaptop.FilterOS.*;
import static lesson_6.tools.filter.сategoriesLaptop.FilterScreenSize.*;


public class Filter {

    public static Scanner scanner = new Scanner(System.in);

    /**
     * Выбор фильтра
     *
     * @param laptopSet
     */
    private static void selectFilter(Set<Laptop> laptopSet) {
        boolean flag = true;
        viewFilterInfo();
        while (flag) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> switchManufactureFilter(laptopSet);
                case "2" -> switchCategoryFilter(laptopSet);
                case "3" -> switchScreenSizeFilter(laptopSet);
                case "4" -> switchOsFilter(laptopSet);
                case "5" -> {

                    flag = false;
                }
                default -> {
                    System.out.println("Введите корректное значение");
                }

            }
            viewFilterInfo();
        }
    }


    /**
     * @param laptopSet
     */
    public static void addFilter(Set<Laptop> laptopSet) {
        selectFilter(laptopSet);
        showSelectedFilterValues(laptopSet);
    }

//    private static void filterSet(Set<Laptop> resutSet,Set<Laptop> tempSet, String request, String one) {
//        if (manufactureFilterStatus) {
//            for (Laptop laptop : resutSet
//            ) {
//                if (one.equalsIgnoreCase(request)) tempSet.add(laptop);
//            }
//            resutSet.retainAll(tempSet);
//            tempSet.clear();
//        }
//    }

    private static void showSelectedFilterValues(Set<Laptop> laptopSet) {

        Set<Laptop> result = new HashSet<>(laptopSet);
        Set<Laptop> temp = new HashSet<>();


        if (manufactureFilterStatus) {
            for (Laptop laptop : result
            ) {
                if (laptop.getManufacture().equalsIgnoreCase(manufacturerRequest)) temp.add(laptop);
            }
            result.retainAll(temp);
            temp.clear();
        }
        if (categoryFilterStatus) {
            for (Laptop laptop : result
            ) {
                if (laptop.getCategory().equalsIgnoreCase(categoryRequest)) temp.add(laptop);
            }
            result.retainAll(temp);
            temp.clear();
        }
        if (screenSizeFilterStatus) {
            for (Laptop laptop : result
            ) {
                if (laptop.getScreenSize().equalsIgnoreCase(screenSizeRequest)) temp.add(laptop);
            }
            result.retainAll(temp);
            temp.clear();
        }

        if (osFilterStatus) {
            for (Laptop laptop : result
            ) {
                if (laptop.getOperatingSystem().equalsIgnoreCase(osRequest)) temp.add(laptop);
            }
            result.retainAll(temp);
            temp.clear();
        }

        if (result.equals(laptopSet)) {
            System.out.println("Вы не выбрали фильтр");
        } else {
            int i = 1;
            for (Laptop out : result
            ) {
                System.out.println(i++ + ". " + out);
            }
        }


    }
}

