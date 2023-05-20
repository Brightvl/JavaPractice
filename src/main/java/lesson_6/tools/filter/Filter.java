package lesson_6.tools.filter;

import lesson_6.goods.laptop.Laptop;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static lesson_6.tools.filter.FilterInfo.infoFilterLaptop;
import static lesson_6.tools.filter.сategoriesLaptop.FilterBrand.*;
import static lesson_6.tools.filter.сategoriesLaptop.FilterCategory.*;
import static lesson_6.tools.filter.сategoriesLaptop.FilterOperatingSystem.*;
import static lesson_6.tools.filter.сategoriesLaptop.FilterReleaseYear.*;


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
                case "1" -> switchingBrandsSelected(laptopSet);
                case "2" -> switchingCategorySelected(laptopSet);
                case "3" -> switchingOsSelected(laptopSet);
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

        Set<Laptop> result = new HashSet<>(laptopSet);
        Set<Laptop> temp = new HashSet<>();

        if (brandSelected) {
            for (Laptop laptop : result
            ) {
                if (laptop.getBrand().equalsIgnoreCase(brandName)) temp.add(laptop);
            }
            result.retainAll(temp);
            temp.clear();
        }
        if (CategoryFilterStatus) {
            for (Laptop laptop : result
            ) {
                if (laptop.getCategory().equalsIgnoreCase(CategoryRequest)) temp.add(laptop);
            }
            result.retainAll(temp);
            temp.clear();
        }

        if (osSelected) {
            for (Laptop laptop : result
            ) {
                if (laptop.getOperatingSystem().equalsIgnoreCase(osName)) temp.add(laptop);
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

