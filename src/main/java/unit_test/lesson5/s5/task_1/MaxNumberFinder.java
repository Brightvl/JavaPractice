package unit_test.lesson5.s5.task_1;

import java.util.List;

public class MaxNumberFinder {

    public static int findMaxNumber(List<Integer> numbers) {
        /**
         * Находит максимальное число в списке.
         *
         * @param numbers (List<Integer>): Список чисел.
         *
         * @return int: Максимальное число.
         *
         * @throws IllegalArgumentException: Если список чисел пуст.
         */
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Список чисел пуст.");
        }

        int maxNumber = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num > maxNumber) {
                maxNumber = num;
            }
        }

        return maxNumber;
    }
}
