package lesson_2.hw_2.sequence;

import static java.lang.Math.sqrt;

public class T1_SumPrimeNumber {

    /**
     * Task_1
     * @param number принимает число которое нужно проверить, является ли оно простым
     * @return возвращает True если число простое
     */
    public static boolean IsPrimeNumber(int number) {
        if (number < 2) return false;

        for (int i = 2; i <= (int) sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    /**
     * Task_1
     * @param number принимает массив чисел
     * @return возвращает сумму простых чисел последовательности
     */
    public static int SumPrimeNumbers(int[] number) {
        int sum = 0;
        for (int element : number) if (IsPrimeNumber(element)) sum += element;
        return sum;
    }

    public static void MarkerPrimeNumber (int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            if (IsPrimeNumber(numbers[i])) {
                System.out.print("[" + numbers[i] + "]");
            } else {
                System.out.print(numbers[i]);
            }
            if (i != numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}
