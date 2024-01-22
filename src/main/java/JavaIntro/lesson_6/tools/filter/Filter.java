package JavaIntro.lesson_6.tools.filter;

import JavaIntro.lesson_6.goods.laptop.Laptop;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static JavaIntro.lesson_6.tools.filter.FilterView.viewFilterInfo;
import static JavaIntro.lesson_6.tools.filter.сategoriesLaptop.FilterManufacture.*;
import static JavaIntro.lesson_6.tools.filter.сategoriesLaptop.FilterCategory.*;
import static JavaIntro.lesson_6.tools.filter.сategoriesLaptop.FilterOS.*;
import static JavaIntro.lesson_6.tools.filter.сategoriesLaptop.FilterScreenSize.*;


public class Filter {

    public static Scanner scanner = new Scanner(System.in);

    /**
     * Выбор фильтра
     *
     * @param laptopSet
     */
    private static void selectFilter(Set<Laptop> laptopSet) {
        viewFilterInfo();
        while (scanner.hasNext()) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> switchManufactureFilter(laptopSet);
                case "2" -> switchCategoryFilter(laptopSet);
                case "3" -> switchScreenSizeFilter(laptopSet);
                case "4" -> switchOsFilter(laptopSet);
                default -> {
                    System.out.println("Введите корректное значение");
                }
            }

            if (choice.equalsIgnoreCase("0")) break;
            else viewFilterInfo();

        }

    }


    /**
     * @param laptopSet
     */
    public static void addFilter(Set<Laptop> laptopSet) {
        selectFilter(laptopSet);
        showSelectedFilterValues(laptopSet);
    }

//    private static void filterSet(boolean filterStatus,
//                                  Set<Laptop> resutSet,
//                                  Set<Laptop> tempSet,
//                                  String request,
//                                  String one) {
//        if (filterStatus) {
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

//        filterSet(manufactureFilterStatus,result,temp,manufacturerRequest);


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

