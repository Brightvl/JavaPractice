package lesson_6.tools.filter.сategoriesLaptop;

import lesson_6.goods.laptop.Laptop;

import java.util.HashSet;
import java.util.Set;

import static lesson_6.tools.filter.Filter.scanner;
import static lesson_6.tools.filter.FilterInfo.viewFilterInfo;

public class FilterScreenSize {

    /**
     * Содержит в себе состояние фильтра
     */
    public static boolean screenSizeFilterStatus = false;
    /**
     * Выбранный пользователем параметр в фильтре
     */
    public static String screenSizeRequest = "";

    /**
     * Переменная для отображения пользователю доступных данных в фильтре
     */
    public static Set<String> screenSizeSetString = new HashSet<>();
    /**
     * Переменная хранит в себе удовлетворяющие фильтру объекты класса Laptop
     */
    public static Set<Laptop> screenSizeSetLaptop = new HashSet<>();

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
    public static void switchScreenSizeFilter(Set<Laptop> laptopSet) {
        if (!screenSizeFilterStatus) {
            screenSizeFilterStatus = true;
            addScreenSizeSetStringFilters(laptopSet); // отобразил на экран по фильтру
            viewFilterInfo();
            System.out.println("Введите один из предложенных фильтров");
            screenSizeRequest = scanner.nextLine();
            addScreenSizeSetLaptopFilter(laptopSet);
            screenSizeSetString.clear();

        } else {
            screenSizeFilterStatus = false;
            screenSizeRequest = "";
            screenSizeSetString.clear();
            screenSizeSetLaptop.clear();
        }
    }

    /**
     * Вывод в консоль дополнительной информации о manufacture.
     * Заполняет screenSizeSetString для дальнейшего вывода его на
     * экран для пользователя
     *
     * @param laptopSet множество с данными о ноутбуках
     */
    public static void addScreenSizeSetStringFilters(Set<Laptop> laptopSet) {
        for (Laptop laptop : laptopSet) {
            screenSizeSetString.add(laptop.getScreenSize());
        }
    }

    /**
     * Заполняет screenSizeSetLaptop значениями класса Laptop
     * удовлетворяющие выбранному фильтру.
     */
    protected static void addScreenSizeSetLaptopFilter(Set<Laptop> laptopSet) {
        if (screenSizeFilterStatus) {
            for (Laptop element : laptopSet
            ) {
                if (element.getOperatingSystem().equalsIgnoreCase(screenSizeRequest))
                    screenSizeSetLaptop.add(element);
            }
        }
    }


}




