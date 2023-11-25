package introduction_to_java.lesson_1.hw_1;

import java.util.Arrays;

/**
 * @Task_2 Дана последовательность целых чисел, оканчивающаяся нулем. Найти сумму положительных чисел, после которых
 * следует отрицательное число.
 * @Input: 1 2 1 2 -1 1 3 1 3 -1 0
 * @Логика расчета:
 * 2 -1 переход -> 2 в сумму
 * 3 -1 переход -> 3 в сумму
 * @Output: 5
 */
public class Task_2 {
    public static void main(String[] args) {
        System.out.println(SumNumbersUpToNegative("1 2 1 2 -1 0 1 3 1 3 -1 0"));
    }

    public static int SumNumbersUpToNegative(String numbers) {
        int[] numArr = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(numArr));
        int sum = 0;
        for (int i = 0; i < numArr.length - 2; i++) if (numArr[i + 1] < 0) sum += numArr[i];
        return sum;
    }
    /*Неточность решения: По 2 - Хорошо, тк if (numArr[i + 1] < 0) - проверяет только что следующее
    числа - отрицательное, то что предыдущее - положительное проверки нет => несколько
    отрицательных в ряд и программа выведет неверный результат
    */
}
