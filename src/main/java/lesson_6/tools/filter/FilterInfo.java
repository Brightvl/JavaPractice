package lesson_6.tools.filter;


import static lesson_6.tools.filter.сategoriesLaptop.FilterManufacture.*;
import static lesson_6.tools.filter.сategoriesLaptop.FilterCategory.*;
import static lesson_6.tools.filter.сategoriesLaptop.FilterOS.*;
import static lesson_6.tools.filter.сategoriesLaptop.FilterScreenSize.*;


public class FilterInfo extends Filter {


    /**
     * Для отображения информации в меню фильтра
     */
    public static void viewFilterInfo() {
        System.out.println("Select number filter\n" +

                (manufactureFilterStatus ? "☑" : "☐") + " 1. Manufacturer (" + manufacturerRequest + ")\n" +
                (!manufacturerSetString.isEmpty() ? "Write the desired filter to the console\n" + manufacturerSetString.toString() + '\n' : "") +

                (categoryFilterStatus ? "☑" : "☐") + " 2. Category (" + categoryRequest + ")\n" +
                (!categorySetString.isEmpty() ? "Write the desired filter to the console\n" + categorySetString.toString() + '\n' : "") +

                (screenSizeFilterStatus ? "☑" : "☐") + " 3. ScreenSize (" + screenSizeRequest + ")\n" +
                (!screenSizeSetString.isEmpty() ? "Write the desired filter to the console\n" + screenSizeSetString.toString() + '\n' : "") +

                (osFilterStatus ? "☑" : "☐") + " 4. OS (" + osRequest + ")\n" +
                (!osSetString.isEmpty() ? "Write the desired filter to the console\n" + osSetString.toString() + '\n' : "") +

                "✖ 5. Confirm!");

    }
}
