package lesson_6.tools.filter;


import static lesson_6.tools.filter.сategoriesLaptop.FilterBrand.*;
import static lesson_6.tools.filter.сategoriesLaptop.FilterCategory.*;
import static lesson_6.tools.filter.сategoriesLaptop.FilterOperatingSystem.*;


public class FilterInfo extends Filter {


    /**
     * Для отображения информации в меню фильтра
     */
    public static void infoFilterLaptop() {
        System.out.println("Select number filter\n" +
                (brandSelected ? "☑" : "☐") + " 1. Brand (" + brandName + ")\n" +
                (!allSetBrands.isEmpty() ? "Write the desired filter to the console\n" + allSetBrands.toString() + '\n' : "") +

                (CategoryFilterStatus ? "☑" : "☐") + " 2. Category (" + CategoryRequest + ")\n" +
                (!allSetCategory.isEmpty() ? "Write the desired filter to the console\n" + allSetCategory.toString() + '\n' : "") +

                (osSelected ? "☑" : "☐") + " 3. OS (" + osName + ")\n" +
                (!allSetOs.isEmpty() ? "Write the desired filter to the console\n" + allSetOs.toString() + '\n' : "") +
                "✖ 4. Confirm!" +

                "");

    }
}
