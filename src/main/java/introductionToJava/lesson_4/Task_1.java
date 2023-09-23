package introductionToJava.lesson_4;

import java.util.Arrays;
import java.util.LinkedList;

public class Task_1 {
    /**
     * Построить однонаправленный список целых чисел. Найти сумму четных элементов списка.
     */
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 25, 45, 24, 26, 78, 90, 100));

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 == 0){
                sum += list.get(i);
            }
        }
        System.out.println(sum);
    }
}
