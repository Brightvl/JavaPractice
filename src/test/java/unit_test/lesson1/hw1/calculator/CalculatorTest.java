package unit_test.lesson1.hw1.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import unit_test.lesson1.hw1.calculator.Calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private Calculator calculator = null;

    // каждый раз до метода
    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
    }

    // каждый раз после метода
    @AfterEach
    void tearDown() {
        this.calculator = null;
    }

    /*
        Задание 1.1 ** В классе Calculator создайте метод calculateDiscount, который принимает сумму покупки и процент
        скидки и возвращает сумму с учетом скидки. Ваша задача - проверить этот метод с использованием библиотеки
        AssertJ. Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать исключение
        ArithmeticException.
    */
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 101})
    @DisplayName("Проверка процентов")
    void calculatingDiscount(int percent) {
        int purchaseAmount = 1000;
        assertThrows(ArithmeticException.class, () -> calculator.calculatingDiscount(purchaseAmount, percent));
    }

    @Test
    @DisplayName("Проверка суммы денег")
    void calculatingDiscount() {
        int purchaseAmount = -1;
        int purchasePercent = 50;
        assertThrows(ArithmeticException.class, () -> calculator.calculatingDiscount(purchaseAmount, purchasePercent));
        assertThrows(ArithmeticException.class, () -> calculator.calculatingDiscount(Integer.MAX_VALUE + 1,
                purchasePercent));
    }
}