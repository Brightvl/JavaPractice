package ExeptionsSeminars.S2;

import java.util.Scanner;

public class HW2 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println(task1());
        task2();
        task3();
        task4();
        scanner.close();
    }

    /**
     * Task_1
     * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
     * и возвращает введенное значение.
     * Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у
     * пользователя ввод данных.
     *
     * @return дробное число
     */
    private static Float task1() {
        float newFloat;
        while (true) {
            try {
                System.out.print("Введите число с плавающей запятой -> ");
                newFloat = scanner.nextFloat();
                if (newFloat % 1 == 0) {
                    System.out.println("Ваше число не является числом с плавающей запятой");
                    continue;
                }
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Введите корректное значение");
                scanner.nextLine();
            }
        }

        return newFloat;
    }


    /**
     * Task_2 исправьте данный код
     * s. Добавил по сути только сам массив, а так, ловит он исключение, как и надо судя по коду.
     * Добавлять нечего
     */
    private static void task2() {

        int[] intArray = new int[]{1, 2, 4, 5, 6, 7, 8, 0, 5, 8};
        try {
            int d = 0;
            double catchedRes = intArray[8] / d;
            System.out.println("catchedRes = " + catchedRes);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }


    /**
     * Task_3 снова исправить.
     * Расставил по порядку исключения, иначе все перехватывал родитель Throwable
     * Ну и исключение "Указатель не может указывать на null!" тоже гон походу, int же не может быть null, убрал
     * В printSum, я так и не понял зачем там исключение, какой нафиг файл нот экзепшн. :/
     * С делением для более корректного вычисления наверное стоило бы переводить в float/double
     */
    public static void task3() {
        try {
            int a = 91;
            int b = 3;
            System.out.println((float) a / b);

            printSum(23, 234);

            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable e) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    /**
     * Task_4
     * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
     * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
     */
    private static void task4() throws Exception {
        System.out.println("Введите строку");
        String string = scanner.nextLine();
        if (string.isEmpty()) {
            throw new Exception("Пустые строки вводить нельзя");
        }
    }

}
