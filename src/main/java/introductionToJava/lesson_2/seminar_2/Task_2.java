package introductionToJava.lesson_2.seminar_2;

/**
 * 2) Дана последовательность из N целых чисел. Найти сумму чисел,
 * оканчивающихся на 5, перед которыми идет четное число.
 */
public class Task_2 {
    public static void main(String[] args) {
        System.out.println(getSum());
    }

    public static int getSum() {
        String str = "67 25 22 35 88 9 2 45 32 5 325 2 105";
        String[] strNums = str.split(" ");
        int result = 0;
        for (int i = 1; i < strNums.length; i++) {
            int number = Integer.parseInt(strNums[i]);
            int previous = Integer.parseInt(strNums[i - 1]);
            if (number % 10 == 5 && previous % 2 == 0) {
                result += number;
            }
        }
        return result;
    }

}


