package introductionToJava.lesson_4.hw_4;

import java.util.Collections;
import java.util.LinkedList;


public class Task1 {

    /**
     * Вывести список на экран в перевернутом виде (без массивов и ArrayList)
     * Пример:
     * 1 -> 2->3->4
     * Вывод:
     * 4->3->2->1
     */
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Разные варианты решения (изначальный список остался нетронут):");
        System.out.println("1. Было->" + list + " Стало->" + reverseList1(list) + " Решено через обратную " +
                "итерацию");
        System.out.println("2. Было->" + list + " Стало->" + reverseList2(list) + " Решено через Collections" +
                ".reverse");
        System.out.println("3. Было->" + list + " Стало->" + reverseList3(list) + " Решено через pop" +
                ".reverse");
        System.out.println("4. Было->" + list + " Стало->" + reverseList4(list) + " Решено через математику" +
                ".reverse");

    }

    /**
     * // Простой варик с обратным отсчетом в цикле
     */
    public static LinkedList<Integer> reverseList1(LinkedList<Integer> list) {
        LinkedList<Integer> newList = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) newList.add(list.get(i));
        return newList;
    }

    /**
     * Через Collections.reverse -> тот же тип сохранен
     */
    public static LinkedList<Integer> reverseList2(LinkedList<Integer> list) {
        LinkedList<Integer> copyList = new LinkedList<>(list);
        Collections.reverse(copyList);
        return copyList;
    }

    /**
     * Через pop. Приходится делать больше итераций
     */
    public static LinkedList<Integer> reverseList3(LinkedList<Integer> list) {
        LinkedList<Integer> copyList = new LinkedList<>(list);
        LinkedList<Integer> resultList = new LinkedList<>();
        for (int i = 0; i < copyList.size() + i; i++) resultList.addFirst(copyList.pop());
        return resultList;
    }

    /**
     * Через заклинания. Без лишних действий
     */
    public static LinkedList<Integer> reverseList4(LinkedList<Integer> list) {
        LinkedList<Integer> copyList = new LinkedList<>(list);
        for (int i = 0; i < copyList.size(); i++) copyList.add(copyList.size() - 1 - i, copyList.pop());
        return copyList;
    }


}

