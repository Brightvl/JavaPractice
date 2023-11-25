package unit_test.lesson3.hw3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import unit_test.lesson3.hw3.User;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        this.user = new User("login", "12345qwerty");
    }

    @AfterEach
    void tearDown() {
        this.user = null;
    }

    @Test
    @DisplayName("1. Проверка правильности аутентификации")
    void testAuthenticate() {
        assertTrue(user.authenticate("login", "12345qwerty"));
    }

    @Test
    @DisplayName("2. Проверка ошибки аутентификации")
    void testNonAuthenticate() {
        assertFalse(user.authenticate("login1", "12345qwerty"));
    }



    @Test
    @DisplayName("3. Проверка на четность")
    void testEvenNumber() {
        assertTrue(user.evenOddNumber(4));
    }

    @Test
    @DisplayName("4. Проверка на нечетность")
    void testOddNumber() {
        assertFalse(user.evenOddNumber(5));
    }

    @Test
    @DisplayName("5. Проверка вхождения в интервал")
    void numberInInterval() {
        assertTrue(user.numberInInterval(25));
    }

    @ParameterizedTest
    @DisplayName("6. Проверка невхождения в интервал")
    @ValueSource(ints = {24, 101})
    void numberInInterval(int number) {
        assertFalse(user.numberInInterval(number));
    }
}
