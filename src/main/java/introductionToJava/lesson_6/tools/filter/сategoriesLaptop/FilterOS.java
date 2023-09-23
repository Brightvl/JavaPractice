package introductionToJava.lesson_6.tools.filter.сategoriesLaptop;

import introductionToJava.lesson_6.goods.laptop.Laptop;
import introductionToJava.lesson_6.tools.filter.Filter;

import java.util.HashSet;
import java.util.Set;

import static introductionToJava.lesson_6.tools.filter.FilterView.viewFilterInfo;

public class FilterOS extends Filter {
    /**
     * Содержит в себе состояние фильтра os
     */
    public static boolean osFilterStatus = false;
    /**
     * Выбранный пользователем параметр в фильтре
     */
    public static String osRequest = "";

    /**
     * Переменная для отображения пользователю доступных данных в фильтре
     */
    public static Set<String> osSetString = new HashSet<>();
    /**
     * Переменная хранит в себе удовлетворяющие фильтру объекты класса Laptop
     */
    public static Set<Laptop> osSetLaptop = new HashSet<>();

    /**
     * Переключатель фильтра категория. Если True заполняем screenSizeSetString для
     * вывода на экран информации о доступных фильтрах типа operation System.
     * Пользователь выбирает фильтр и пишет в консоль. Значение выбранного
     * фильтра сохраняется в переменную screenSizeRequest В screenSizeSetLaptop
     * добавляются значения класса Laptop удовлетворяющие выбранному фильтру.
     * Если переключатель False стираются все данные.
     *
     * @param laptopSet – множество с данными о ноутбуках
     */
    public static void switchOsFilter(Set<Laptop> laptopSet) {
        if (!osFilterStatus) {
            osFilterStatus = true;
            addOsSetStringFilter(laptopSet);
            viewFilterInfo();
            System.out.println("Enter one of the suggested filters\n" + osSetString);
            osRequest = scanner.nextLine();
            addOsSetLaptopFilter(laptopSet);
            osSetString.clear();

        } else {
            osFilterStatus = false;
            osRequest = "";
            osSetString.clear();
            osSetLaptop.clear();
        }
    }

    /**
     * Вывод в консоль дополнительной информации о manufacture
     * Заполняет screenSizeSetString для дальнейшего вывода его на
     * экран для пользователя
     *
     * @param laptopSet множество с данными о ноутбуках
     */
    private static void addOsSetStringFilter(Set<Laptop> laptopSet) {
        for (Laptop laptop : laptopSet) {
            osSetString.add(laptop.getOperatingSystem());
        }
    }

    /**
     * Заполняет screenSizeSetLaptop значениями класса Laptop
     * удовлетворяющие выбранному фильтру.
     */
    private static void addOsSetLaptopFilter(Set<Laptop> laptopSet) {
        if (osFilterStatus) {
            for (Laptop element : laptopSet
            ) {
                if (element.getOperatingSystem().equalsIgnoreCase(osRequest))
                    osSetLaptop.add(element);
            }
        }
    }


}


