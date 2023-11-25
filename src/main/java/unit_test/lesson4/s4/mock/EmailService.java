package unit_test.lesson4.s4.mock;

public class EmailService {

    private EmailSender emailSender;

    public EmailService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendWelcomeEmail(String recipient) {
        // Логика отправки приветственного письма
        emailSender.sendEmail(recipient, "Добро пожаловать", "Добро пожаловать на наш сайт!");
    }
}
