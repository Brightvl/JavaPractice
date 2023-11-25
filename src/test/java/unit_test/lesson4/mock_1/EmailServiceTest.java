package unit_test.lesson4.mock_1;

import unit_test.lesson4.s4.mock_1.EmailSender;
import unit_test.lesson4.s4.mock_1.EmailService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class EmailServiceTest {

    @Test
    public void testSendWelcomeEmailWithMock() {
        // Создаем мок EmailSender с помощью Mockito
        EmailSender emailSender = mock(EmailSender.class);


        // Создаем экземпляр EmailService с моком
        EmailService emailService = new EmailService(emailSender);

        // Вызываем метод sendWelcomeEmail
        emailService.sendWelcomeEmail("user@example.com");

        // Проверяем, что метод sendEmail был вызван с правильными аргументами
        verify(emailSender).sendEmail(
                "user@example.com",
                "Добро пожаловать",
                "Добро пожаловать на наш сайт!");
    }
}