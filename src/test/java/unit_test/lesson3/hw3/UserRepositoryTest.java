package unit_test.lesson3.hw3;

import org.junit.jupiter.api.*;
import unit_test.lesson3.hw3.User;
import unit_test.lesson3.hw3.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
class UserRepositoryTest {
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        this.userRepository = new UserRepository();
    }

    @AfterEach
    void tearDown() {
        userRepository = null;
    }

    @Test
    @DisplayName("1. Проверка правильности добавления пользователя")
    void testAddUser() {
        User newUser3 = new User("login3", "123qwe");
        userRepository.addUser(newUser3);

        assertTrue(userRepository.data.contains(newUser3));
    }
    @Test
    @DisplayName("2. Проверка ошибки добавления пользователя")
    void testErrorAddUser() {
        assertFalse(userRepository.data.contains(new User("login3", "123qwe")));
    }

    @Test
    @DisplayName("3. Проверка правильности поиска по имени")
    void testFindByName() {
        userRepository.addUser(new User("login", "12345qwerty"));
        userRepository.addUser(new User("login2", "12345qwe"));
        userRepository.addUser(new User("login3", "123qwe"));

        assertTrue(userRepository.findByName("login3"));
    }

    @Test
    @DisplayName("4. Проверка ошибки поиска по имени")
    void testErrorFindByName() {
        userRepository.addUser(new User("login", "12345qwerty"));
        userRepository.addUser(new User("login2", "12345qwe"));
        userRepository.addUser(new User("login3", "123qwe"));

        assertFalse(userRepository.findByName("login4"));
    }

    @Test
    @DisplayName("5. Проверка разлогинивания пользователя")
    void testLogoutAllExceptAdminsCheckUser() {
        User user = new User("login", "12345qwe");// создаем пользователя
        userRepository.addUser(user); // добавляем в репу
        user.authenticate("login", "12345qwe"); //Авторизуем

        userRepository.logoutAllExceptAdmins(); // разлогиним всех кроме админа

        assertFalse(user.isAuthenticate);
    }

    @Test
    @DisplayName("6. Проверка не разлогинивания админа")
    void testLogoutAllExceptAdminsCheckAdmin() {
        User userAdmin = new User("login2", "12345qwe", true);// создаем админа
        userRepository.addUser(userAdmin); // добавляем в репу
        userAdmin.authenticate("login2", "12345qwe"); //Авторизуем

        userRepository.logoutAllExceptAdmins(); // разлогиним всех кроме админа

        assertTrue(userAdmin.isAuthenticate);
    }

}