package unit_test.lesson5.s5.task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    public static List<Integer> generateRandomNumbers(int n) {
        /**
         * Генерирует список случайных чисел.
         *
         * @param n (int): Количество случайных чисел в списке.
         *
         * @return List<Integer>: Список случайных чисел.
         */
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(100) + 1; // Генерируем случайное число от 1 до 100
            randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }
}