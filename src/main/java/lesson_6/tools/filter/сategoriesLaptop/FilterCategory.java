package lesson_6.tools.filter.сategoriesLaptop;

import lesson_6.goods.laptop.Laptop;

import java.util.HashSet;
import java.util.Set;

import static lesson_6.tools.filter.Filter.scanner;
import static lesson_6.tools.filter.FilterInfo.infoFilterLaptop;

public class FilterCategory {

    public static boolean CategoryFilterStatus = false; // Статус фильтра активен или нет
    public static String CategoryRequest = ""; //Запрос переданный фильтру

    /**
     * Хранит в себе доступные категории
     */
    public static Set<String> allSetCategory = new HashSet<>();
    /**
     * Содержит в себе совпадающие позиции категорий по фильтру
     */
    public static Set<Laptop> setCategory = new HashSet<>();

    /**
     * Вывод в консоль дополнительной информации о категориях
     * Заполняет allSetCategory для дальнейшего вывода его на экран для пользователя
     */
    private static void displayFiltersCategory(Set<Laptop> laptopSet) {
        for (Laptop laptop : laptopSet) {
            allSetCategory.add(laptop.getCategory());
        }
    }

    /**
     * Переключатель для фильтра
     */
    public static void switchingCategorySelected(Set<Laptop> laptopSet) {
        if (!CategoryFilterStatus) {
            CategoryFilterStatus = true;
            displayFiltersCategory(laptopSet); // отобразил на экран по фильтру
            infoFilterLaptop();
            System.out.println("Введите один из предложенных фильтров");
            CategoryRequest = scanner.nextLine();
            addCategoryFilter(laptopSet);
            allSetCategory.clear();

        } else {
            CategoryFilterStatus = false;
            CategoryRequest = "";
            allSetCategory.clear();
            setCategory.clear();
        }
    }

    /**
     * Добавляет значения в множество с операционными системами, если фильтр включен
     */
    private static void addCategoryFilter(Set<Laptop> laptopSet) {
        if (CategoryFilterStatus) {
            for (Laptop element : laptopSet
            ) {
                try {
                    if (element.getCategory().equalsIgnoreCase(CategoryRequest))
                        setCategory.add(element);
                } catch (NullPointerException e) {
                }
            }
        }
    }


}
