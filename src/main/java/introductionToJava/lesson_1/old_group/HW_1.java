package introductionToJava.lesson_1.old_group;

import java.util.Scanner;

public class HW_1 {


    public static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("""
                Введи цифру задания:
                1. Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
                2. Вывести все простые числа от 1 до 1000.
                3. Реализовать простой калькулятор
                4. Решение уравнения типа 2? + ?5 = 6?
                Введите нужное задание ->\s""");

        String choose = iScanner.nextLine();
        switch (choose) {
            case "1" -> FactorialILICHTOTUTHZVASHE();
            case "2" -> PrimeNumbers();
            case "3" -> MiniCalculator();
            case "4" -> RestoreEquation();
            default -> System.out.println("пока пока чел");
        }
        iScanner.close();


    }

    // #1. Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
    // И ЧЕ ЭТО ЗА ЗАДАНИЕ ВООБЩЕ, короче я понял что тут факториал нужно искать.
    public static void FactorialILICHTOTUTHZVASHE() {
        System.out.println("Введите число для преобразования ->");
        int n = Integer.parseInt(iScanner.nextLine());
        int triangularNumber = 0;
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            triangularNumber += i;
            factorial *= i;
        }
        System.out.println("Треугольное число: " + triangularNumber);
        System.out.println("Факториал: " + factorial);

    }


    // #2. Вывести все простые числа от 1 до 1000.
    public static void PrimeNumbers() {
        for (int i = 2; i <= 1000; i++) { //Первый цикл для перебора самих чисел
            boolean isPrime = true;
            for (int j = 2; j < i; j++) { //второй цикл для перебора делителей
                if (i % j == 0) { //Если число делится на делитель без остатка
                    isPrime = false;
                    break; // Выход из внутреннего цикла
                }
            }
            if (isPrime) System.out.print("(" + i + ")" + " ");
        }
    }

    // #3. Реализовать простой калькулятор
    public static void MiniCalculator() {
        System.out.println("""
                Доступные операции:
                Сложение -> a + b = c
                Вычитание -> a - b = c
                Умножение - > a * b = c
                Деление -> a / b = c
                Возведение в степень -> a^b = c""");
        System.out.print("\nВведите выражение -> ");
        String example = iScanner.nextLine();
        String answer = "Проверьте правильность ввода";

        if (example.contains("+")) { // Сначала определяю есть ли в строке +
            /*Символ \\D является сокращением для символьного класса [^0-9], который соответствует любому символу,
            кроме цифр от 0 до 9. Символ + означает один или несколько повторений предыдущего символа или группы*/
            String[] result = example.split("\\D+"); // извлекаю из строки числа и записываю в массив
            answer = String.valueOf((Integer.parseInt(result[0]) + Integer.parseInt(result[1]))); // суммирую число,
        } else if (example.contains("-")) {
            String[] result = example.split("\\D+");
            answer = String.valueOf((Integer.parseInt(result[0]) - Integer.parseInt(result[1])));
        } else if (example.contains("*")) {
            String[] result = example.split("\\D+");
            answer = String.valueOf((Integer.parseInt(result[0]) * Integer.parseInt(result[1])));
        } else if (example.contains("/")) {
            String[] result = example.split("\\D+");
            answer = String.valueOf((Double.parseDouble(result[0]) / Double.parseDouble(result[1])));
        } else if (example.contains("^")) { // Сначала определяю есть ли в строке +
            String[] result = example.split("\\D+");
            answer = String.valueOf(Math.pow((Integer.parseInt(result[0])), (Integer.parseInt(result[1]))));
        }
        System.out.println(answer);

    }


    /*
     * +Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
     * например, 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
     * Предложить хотя бы одно решение или сообщить, что его нет.
     */

    public static void RestoreEquation() {
        System.out.println("Введите выражение вида 5? + ?5 = 60. Можете ставить вопросы в любых местах -> ");
        Scanner iScanner = new Scanner(System.in);
        String equation = iScanner.nextLine(); // Принимаем значение от пользователя
        String[] parts = equation.split(" "); // разбиваем его по пробелам и заносим в массив
        String q = parts[0];    // достаем и записываем в переменные значения каждого слагаемого
        String w = parts[2];
        String e = parts[4];

        String result = ""; // строка для вывода
        boolean foundSolution = false; // флаг для определения, решение существует или нет, вывод будет в цикле
        for (int i = 0; i <= 9; i++) { // Логика такая что нужно перебрать все возможные вариации чисел, чисел у нас их
            // всего 10, от 0 до 9. Итого три цикла, по одному на каждое возможное неизвестное. Неизвестным считается
            // вопросик и вместо него нужно поставить правильное число. Один знак это char можно заменить функцией
            // replace. Короче в тупую подставляем цифры и смотрим когда решение станет верным.
            // (char)
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    String q1 = q.replace('?', (char) ('0' + i));
                    String w1 = w.replace('?', (char) ('0' + j));
                    String e1 = e.replace('?', (char) ('0' + k));
                    // после каждой итерации проверяется условие, еси оно верно записывается значение в переменную и
                    // флаг меняется на true
                    if (Integer.parseInt(q1) + Integer.parseInt(w1) == Integer.parseInt(e1)) {
                        result = q1 + " + " + w1 + " = " + e1 + "\n";
                        foundSolution = true;
                    }
                }
            }
        }

        if (!foundSolution) {
            result += "Решения нет";
        }
        else{
            System.out.println(result);
        }



    }
}



