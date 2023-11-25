package introduction_to_java.lesson_6.tools.filter.сategoriesLaptop;

import introduction_to_java.lesson_6.goods.laptop.Laptop;

import java.util.HashSet;
import java.util.Set;

import static introduction_to_java.lesson_6.tools.filter.Filter.scanner;
import static introduction_to_java.lesson_6.tools.filter.FilterView.viewFilterInfo;

public class FilterCategory {
    /**
     * Содержит в себе состояние фильтра category
     */
    public static boolean categoryFilterStatus = false;
    /**
     * Выбранный пользователем параметр в фильтре
     */
    public static String categoryRequest = "";

    /**
     * Переменная для отображения пользователю доступных данных в фильтре
     */
    public static Set<String> categorySetString = new HashSet<>();
    /**
     * Переменная хранит в себе удовлетворяющие фильтру объекты класса Laptop
     */
    public static Set<Laptop> categorySetLaptop = new HashSet<>();

    /**
     * Переключатель фильтра категория.
     * Если True заполняем categorySetString для вывода на экран информации о
     * доступных фильтрах типа category. Пользователь выбирает фильтр и пишет в консоль.
     * Значение выбранного фильтра сохраняется в переменную categoryRequest
     * В categorySetLaptop добавляются значения класса Laptop удовлетворяющие выбранному фильтру.
     * Если переключатель False стираются все данные.
     * @param laptopSet множество с данными о ноутбуках
     */
    public static void switchCategoryFilter(Set<Laptop> laptopSet) {
        if (!categoryFilterStatus) {
            categoryFilterStatus = true;
            addCategorySetStringFilter(laptopSet);
            viewFilterInfo();
            System.out.println("Enter one of the suggested filters\n"+categorySetLaptop);
            categoryRequest = scanner.nextLine();
            addCategorySetLaptopFilter(laptopSet);
            categorySetString.clear();

        } else {
            categoryFilterStatus = false;
            categoryRequest = "";
            categorySetString.clear();
            categorySetLaptop.clear();
        }
    }

    /**
     * Вывод в консоль дополнительной информации о категориях
     * Заполняет categorySetString для дальнейшего вывода его на экран для пользователя
     */
    private static void addCategorySetStringFilter(Set<Laptop> laptopSet) {
        for (Laptop laptop : laptopSet) {
            categorySetString.add(laptop.getCategory());
        }
    }

    /**
     * Заполняет categorySetLaptop значениями класса Laptop удовлетворяющие выбранному фильтру.
     */
    private static void addCategorySetLaptopFilter(Set<Laptop> laptopSet) {
        if (categoryFilterStatus) {
            for (Laptop element : laptopSet
            ) {
                if (element.getCategory().equalsIgnoreCase(categoryRequest))
                    categorySetLaptop.add(element);
            }
        }
    }
}




