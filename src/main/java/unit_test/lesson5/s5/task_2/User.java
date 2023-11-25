package unit_test.lesson5.s5.task_2;

// Класс User
public class User {
    private int id;
    private String username;

    public User(int userId, String expectedUsername) {
        id = userId;
        username = expectedUsername;
    }

    public User() {
    }

    // Конструктор, геттеры и сеттеры

    public String getUsername() {
        return username;
    }
}



