package introductionToJava.lesson_2.hw_2.sequence;

import java.util.Scanner;

public class T3_EditingSequences {

    /**
     *Task_3
     * @param number принимает числовую последовательность.
     * @return массив чисел в котором отрицательные числа заменены на сумму индексов двухзначных чисел массива.
     */
    public static int[] ReplacingNegatives(int[] number) {
        int sum = 0;
        for (int i = 0; i < number.length; i++) {
            if (Math.abs(number[i]) >= 10 && Math.abs(number[i]) <= 99) {
                sum += i;
            }
        }
        for (int i = 0; i < number.length; i++) {
            if (number[i] < 0) {
                number[i] = sum;
            }
        }
        return number;
    }
    /**и
     * @return массив чисел последовательности
     */
    public static int[] GeneratorSequence() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сначала нужно задать последовательность." +
                "\nВведи первое число последовательности ->  ");
        int start = Integer.parseInt(scanner.nextLine());
        System.out.println("Второе число -> ");
        int end = scanner.nextInt();
        scanner.close();

        int arrayRange = Math.abs(start - end) + 1;

        int[] naturalNumber = new int[arrayRange];

        if (start < end) {
            int numberSequence = start;
            for (int i = 0; i < arrayRange; i++) {
                naturalNumber[i] = numberSequence;
                numberSequence++;
            }
        } else {
            int numberSequence = start;
            for (int i = 0; i < arrayRange; i++) {
                naturalNumber[i] = numberSequence;
                numberSequence--;
            }
        }
        return naturalNumber;
    }
}




