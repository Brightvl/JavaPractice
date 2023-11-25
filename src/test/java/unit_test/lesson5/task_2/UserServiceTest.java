package unit_test.lesson5.task_2;

import unit_test.lesson5.s5.task_2.User;
import unit_test.lesson5.s5.task_2.UserRepository;
import unit_test.lesson5.s5.task_2.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    UserRepository userRepository;
    UserService userService;
    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testUserServiceWithUserRepository() {
        // Задаем ожидаемый результат
        int userId = 1;
        String expectedUsername = "JohnDoe"; // Предположим, что у пользователя с ID 1 такое имя

        // Устанавливаем ожидание вызова метода getUserById с userId и возвращаем ожидаемый объект User
        when(userRepository.getUserById(userId)).thenReturn(new User(userId, expectedUsername));

        // Вызываем метод getUserUsernameById из UserService
        String username = userService.getUserUsernameById(userId);

        // Проверяем, что метод getUserById был вызван с ожидаемым userId
        verify(userRepository).getUserById(userId);

        // Проверяем, что результат соответствует ожиданиям
        assertEquals(expectedUsername, username);
    }
}