package unit_test.lesson1.hw1.calculator;

public class Calculator {
    /*
        Задание 1.1 ** В классе Calculator создайте метод calculateDiscount, который принимает сумму покупки и процент
        скидки и возвращает сумму с учетом скидки. Ваша задача - проверить этот метод с использованием библиотеки
        AssertJ. Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать исключение
        ArithmeticException. Не забудьте написать тесты для проверки этого поведения.
     */
    public double calculatingDiscount(double purchaseAmount, int discountAmount) {
        if (discountAmount < 1 || discountAmount > 100) {
            throw new ArithmeticException("Процент должен быть в пределе от 1 до 100");
        } else if (purchaseAmount < 0 || purchaseAmount > Integer.MAX_VALUE) {
            throw new ArithmeticException("Неадекватная сумма");
        }
        return purchaseAmount - (purchaseAmount * discountAmount) / 100;
    }
}