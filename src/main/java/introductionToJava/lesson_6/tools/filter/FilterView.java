package introductionToJava.lesson_6.tools.filter;


import static introductionToJava.lesson_6.tools.filter.сategoriesLaptop.FilterManufacture.*;
import static introductionToJava.lesson_6.tools.filter.сategoriesLaptop.FilterCategory.*;
import static introductionToJava.lesson_6.tools.filter.сategoriesLaptop.FilterOS.*;
import static introductionToJava.lesson_6.tools.filter.сategoriesLaptop.FilterScreenSize.*;


public class FilterView extends Filter {


    /**
     * Для отображения информации в меню фильтра
     */
    public static void viewFilterInfo() {
        String message = "Write the desired filter to the console\n";
        int temp = 1;
        System.out.println("Select number filter\n" +

                (manufactureFilterStatus ? "☑ " : "☐ ") + temp++ + ". Manufacturer (" + manufacturerRequest + ")\n" +

                (categoryFilterStatus ? "☑ " : "☐ ") + temp++ + ". Category (" + categoryRequest + ")\n" +

                (screenSizeFilterStatus ? "☑ " : "☐ ") + temp++ + ". ScreenSize (" + screenSizeRequest + ")\n" +

                (osFilterStatus ? "☑ " : "☐ ") + temp++ +". OS (" + osRequest + ")\n" +

                "✖ 0. Confirm!");
    }
}
