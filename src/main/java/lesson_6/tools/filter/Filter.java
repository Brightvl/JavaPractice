package lesson_6.tools.filter;

import lesson_6.goods.Laptop;

import java.util.*;

import static lesson_6.tools.filter.CheckFilters.filtersCheck;
import static lesson_6.tools.filter.CheckFilters.newSetLaptop;
import static lesson_6.tools.filter.FilterOperatingSystem.filterOsSelection;
import static lesson_6.tools.filter.FilterOperatingSystem.osSelected;


public class Filter {

    private static Set<Laptop> filterSet = new HashSet<>();

    /**
     * brand
     */
    private static boolean brandSelected = false;
    private static String brandName = "";

    /**
     * releaseYear
     */
    private static boolean releaseYearSelected = false;
    private static int releaseYear = 0000;


    protected static void info() {
        System.out.println("Select number filter\n" +
                (brandSelected ? "\u2611" : "\u2610") + " 1. Brand (" + brandName + ")\n" +
                (releaseYearSelected ? "\u2611" : "\u2610") + " 2. ReleaseYear (" + releaseYear + ")\n" +
                "\u2716 4. Confirm!");

    }

    private static void selectFilter() {
        boolean flag = true;
        info();

        Scanner scanner = new Scanner(System.in);
        while (flag) {

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    brandSelected = !brandSelected;
                    if (brandSelected) {
                        System.out.print("Enter brand name -> ");
                        brandName = scanner.nextLine();
                    } else {
                        System.out.println("Filter deleted");
                    }
                }
                case "2" -> {
                    releaseYearSelected = !releaseYearSelected;
                    if (releaseYearSelected) {
                        System.out.print("Enter release year -> ");
                        try {
                            releaseYear = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("вы не ввели число");
                            releaseYearSelected = !releaseYearSelected;
                        }

                    } else {
                        System.out.println("Filter deleted");
                    }
                }
                case "3" -> {
                    if (!osSelected) {
                        System.out.print("Enter operating system name -> ");
                        filterOsSelection(scanner.nextLine());
                    } else {
                        filterOsSelection("");
                    }


                }
                case "4" -> {
                    flag = false;
                }
                default -> {
                    System.out.println("Введите корректное значение");
                }
            }
            info();
        }
        scanner.close();
    }

    public static void addFilter(Set<Laptop> laptopSet) {
        selectFilter();
        filtersCheck(laptopSet);

        }
    }

