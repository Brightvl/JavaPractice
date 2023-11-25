package unit_test.lesson3.s3;



import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import unit_test.lesson3.s3.CalculatorView;

import static org.testng.AssertJUnit.assertEquals;

public class CalculatorViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private CalculatorView calculatorView;

    @Before
    public void setUpStreams() {
        // Создаем объект CalculatorView перед каждым тестом
        this.calculatorView = new CalculatorView();

        // Перехватываем стандартный вывод (System.out)
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        // Восстанавливаем оригинальный стандартный вывод
        System.setOut(originalOut);
    }

    @Test
    public void testDisplayResult() {
        // Вызываем метод displayResult с аргументом 10.0
        calculatorView.displayResult(10.0);

        // Проверяем, что вывод соответствует ожидаемому результату
        assertEquals("Результат: 10.0" + System.lineSeparator(), outContent.toString());
    }
}
