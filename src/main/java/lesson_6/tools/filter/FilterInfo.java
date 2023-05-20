package lesson_6.tools.filter;


import static lesson_6.tools.filter.category.FilterBrand.*;
import static lesson_6.tools.filter.category.FilterOperatingSystem.*;
import static lesson_6.tools.filter.category.FilterReleaseYear.*;

public class FilterInfo extends Filter {

    /**
     * Для отображения информации в меню фильтра
     */
    public static void infoFilterLaptop() {
        System.out.println("Select number filter\n" +
                (brandSelected ? "\u2611" : "\u2610") + " 1. Brand (" + brandName + ")\n" +
                (!allSetBrands.isEmpty() ? "Write the desired filter to the console\n" + allSetBrands.toString() + '\n' : "") +

                (releaseYearSelected ? "\u2611" : "\u2610") + " 2. Release year (" + releaseYear + ")\n" +
                (!allSetYear.isEmpty() ? "Write the desired filter to the console\n" + allSetYear.toString() + '\n' : "") +

                (osSelected ? "\u2611" : "\u2610") + " 3. OS (" + osName + ")\n" +
                (!allSetOs.isEmpty() ? "Write the desired filter to the console\n" + allSetOs.toString() + '\n' : "") +
                "\u2716 4. Confirm!" +

                "");

    }
}
