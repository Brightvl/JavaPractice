package introductionToJava.lesson_2.hw_2.sequence;


import java.util.Arrays;
import java.util.Scanner;

import static introductionToJava.lesson_2.hw_2.sequence.T1_SumPrimeNumber.MarkerPrimeNumber;
import static introductionToJava.lesson_2.hw_2.sequence.T1_SumPrimeNumber.SumPrimeNumbers;
import static introductionToJava.lesson_2.hw_2.sequence.T2_SequenceCheck.AscendingSequenceCheck;
import static introductionToJava.lesson_2.hw_2.sequence.T3_EditingSequences.GeneratorSequence;
import static introductionToJava.lesson_2.hw_2.sequence.T3_EditingSequences.ReplacingNegatives;

public class Main {
    public static void main(String[] args) {
        System.out.print("""
                Задачи:
                1. Дана последовательность N целых чисел. Найти сумму простых чисел.
                2. Дана последовательность из N целых чисел. Верно ли, что последовательность является возрастающей.
                3. Дан массив целых чисел. Заменить отрицательные элементы на сумму индексов двузначных элементов массива.
                Введи цифру задания ->\s""");
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.nextLine();

        switch (choose) {
            case "1" -> {
                int[] number = GeneratorSequence();
                System.out.println("В квадратных скобках [простое число]:");
                MarkerPrimeNumber(number);
                System.out.println("Сумма простых чисел = " + SumPrimeNumbers(number));
            }
            case "2" -> {
                int[] number = GeneratorSequence();
                if (AscendingSequenceCheck(number, true)) {
                    System.out.println(Arrays.toString(number));
                    System.out.println("Последовательность возрастающая");
                } else if (AscendingSequenceCheck(number, false)) {
                    System.out.println(Arrays.toString(number));
                    System.out.println("Последовательность убывающая");
                }

            }
            case "3" -> {
                int[] number = GeneratorSequence();
                System.out.println("Было:  " + Arrays.toString(number));
                System.out.println("Стало: " + Arrays.toString(ReplacingNegatives(number)));
            }
            default -> System.out.println("Вы ввели что то другое");
        }
        scanner.close();
    }
}



