package unit_test.lesson1.s1;

import org.junit.jupiter.api.*;


import static org.testng.AssertJUnit.assertEquals;

public class TaskTest {

    // Статический блок кода, который будет выполнен перед всеми тестами
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Выполнение перед всеми тестами");
        // Инициализация глобальных ресурсов
    }

    // Блок кода, который будет выполнен после всех тестов
    @AfterAll
    public static void afterAll() {
        System.out.println("Выполнение после всех тестов");
        // Освобождение глобальных ресурсов
    }

    // Блок кода, который будет выполнен перед каждым тестом
    @BeforeEach
    public void beforeEach() {
        System.out.println("Выполнение перед каждым тестом");
        // Инициализация ресурсов для каждого теста
    }

    // Блок кода, который будет выполнен после каждого теста
    @AfterEach
    public void afterEach() {
        System.out.println("Выполнение после каждого теста");
        // Очистка ресурсов после каждого теста
    }

    // Основной тестовый метод
    @Test
    @DisplayName("Тест суммирования")
    public void testSum() {
        System.out.println("Выполнение теста суммирования");
        int a = 2;
        int b = 3;
        int sum = a + b;
        assertEquals(5, sum);
    }

    // Отключенный тест
    @Test
    @Disabled
    @DisplayName("Отключенный тест")
    public void disabledTest() {
        System.out.println("Этот тест отключен и не будет выполнен");
    }
}

