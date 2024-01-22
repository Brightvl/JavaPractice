package JavaIntro.lesson_1.seminar_1;

import java.util.Scanner;

public class Task_1 {

// Given an integer number n, return the difference between the product of its digits and the sum of its digits.
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите число");
        int num = scanner.nextInt();
        System.out.println(SubtractProductAndSum(num));
        scanner.close();
    }

    /**
     * @param num принимаем параметр
     * @return произведение - сумма
     */
    public  static int SubtractProductAndSum(int num){

        int product = 1;
        int sum = 0;
        while (num != 0) {
            product *= num % 10;
            sum += num % 10;
            num /= 10;
        }
        return product-sum;
    }

}
