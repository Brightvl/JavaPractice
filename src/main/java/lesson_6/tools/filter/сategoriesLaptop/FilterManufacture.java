package lesson_6.tools.filter.сategoriesLaptop;

import lesson_6.goods.laptop.Laptop;

import java.util.HashSet;
import java.util.Set;

import static lesson_6.tools.filter.Filter.scanner;
import static lesson_6.tools.filter.FilterInfo.viewFilterInfo;

public class FilterManufacture {

    /**
     * Содержит в себе состояние фильтра manufacturer
     */
    public static boolean manufactureFilterStatus = false;
    /**
     * Выбранный пользователем параметр в фильтре
     */
    public static String manufacturerRequest = "";

    /**
     * Переменная для отображения пользователю доступных данных в фильтре
     */
    public static Set<String> manufacturerSetString = new HashSet<>();
    /**
     * Переменная хранит в себе удовлетворяющие фильтру объекты класса Laptop
     */
    public static Set<Laptop> manufacturerSetLaptop = new HashSet<>();


    /**
     * Переключатель фильтра категория. Если True заполняем manufacturerSetString для
     * вывода на экран информации о доступных фильтрах типа manufacturer.
     * Пользователь выбирает фильтр и пишет в консоль. Значение выбранного
     * фильтра сохраняется в переменную manufacturerRequest В manufacturerSetLaptop
     * добавляются значения класса Laptop удовлетворяющие выбранному фильтру.
     * Если переключатель False стираются все данные.
     *
     * @param laptopSet – множество с данными о ноутбуках
     */
    public static void switchManufactureFilter(Set<Laptop> laptopSet) {
        if (!manufactureFilterStatus) {
            manufactureFilterStatus = true;
            addManufactureSetStringFilter(laptopSet); // отобразил на экран по фильтру
            viewFilterInfo();
            System.out.println("Введите один из предложенных фильтров");
            manufacturerRequest = scanner.nextLine();
            addManufactureSetLaptopFilter(laptopSet);
            manufacturerSetString.clear();

        } else {
            manufactureFilterStatus = false;
            manufacturerRequest = "";
            manufacturerSetString.clear();
            manufacturerSetLaptop.clear();
        }
    }

    /**
     * Вывод в консоль дополнительной информации о manufacture
     * Заполняет manufacturerSetString для дальнейшего вывода его на
     * экран для пользователя
     *
     * @param laptopSet множество с данными о ноутбуках
     */
    private static void addManufactureSetStringFilter(Set<Laptop> laptopSet) {
        for (Laptop laptop : laptopSet) {
            manufacturerSetString.add(laptop.getManufacture());
        }
    }

    /**
     * Заполняет manufacturerSetLaptop значениями класса Laptop
     * удовлетворяющие выбранному фильтру.
     */
    private static void addManufactureSetLaptopFilter(Set<Laptop> laptopSet) {
        if (manufactureFilterStatus) {
            for (Laptop element : laptopSet
            ) {
                if (element.getManufacture().equalsIgnoreCase(manufacturerRequest))
                    manufacturerSetLaptop.add(element);
            }
        }
    }

}
