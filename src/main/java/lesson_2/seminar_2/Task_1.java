package lesson_2.seminar_2;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * Реализуйте функцию pow(x, n), которая вычисляет x в степени n (т. е. xn).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Task_1 {
    public static void main(String[] args) {
        System.out.println(CopyPowFunction(2, -5));
    }

    public static double CopyPowFunction(double number, int degree) {
        degree = Math.abs(degree);
        int result = 1;
        for (int i = 0; i < degree; i++) result *= number;
        return result;
    }
}


