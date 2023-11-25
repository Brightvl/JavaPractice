package unit_test.lesson2.s2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit_test.lesson2.s2.Animal;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    private Animal animal;

    @BeforeEach
    void setUp() {
        animal = new Animal("TestAnimal", 2);
    }

    @AfterEach
    void tearDown() {
        animal = null;
    }

    @Test
    void eat() {
        // Проверяем, что метод eat выводит правильное сообщение
        assertEquals("TestAnimal is eating.", getConsoleOutput(() -> animal.eat()));
    }

    @Test
    void sleep() {
        assertEquals("TestAnimal is sleeping.", getConsoleOutput(() -> animal.sleep()));
    }

    @Test
    void makeSound() {
        assertEquals("TestAnimal makes a sound.", getConsoleOutput(() -> animal.makeSound()));
    }

    // Вспомогательный метод для захвата вывода в консоль
    private String getConsoleOutput(Runnable runnable) {
       // Сохраняем стандартный вывод
        var standardOut = System.out;
        try {
            // Создаем новый поток вывода
            var outputStream = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outputStream));

            // Выполняем метод, который вызывает вывод в консоль
            runnable.run();

            // Возвращаем вывод в виде строки
            return outputStream.toString().trim();
        } finally {
            // Восстанавливаем стандартный вывод
            System.setOut(standardOut);
        }
    }
}