package introduction_to_java.lesson_6;

import static introduction_to_java.lesson_6.goods.laptop.LaptopSet.fillLaptopSetFromCSV;
import static introduction_to_java.lesson_6.goods.laptop.LaptopSet.laptopSet;
import static introduction_to_java.lesson_6.tools.filter.Filter.addFilter;


/**
 * • Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 * • Создать множество ноутбуков.
 * • Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
 * Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * • Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
 * • Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */
public class main {

    private static String path = "src/main/java/IntroToJava.lesson_6/goods/laptop/csvFiles/laptops.csv";

    public static void main(String[] args) {

        fillLaptopSetFromCSV(path);
        addFilter(laptopSet);

    }


}
