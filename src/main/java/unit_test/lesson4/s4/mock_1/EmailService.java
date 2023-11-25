package unit_test.lesson4.s4.mock_1;

public class EmailService {
    private EmailSender emailSender;

    public EmailService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendWelcomeEmail(String recipient) {
        String subject = "Добро пожаловать";
        String body = "Добро пожаловать на наш сайт!";
        emailSender.sendEmail(recipient, subject, body);
    }
}
