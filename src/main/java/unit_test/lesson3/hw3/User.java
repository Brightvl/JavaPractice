package unit_test.lesson3.hw3;

public class User {

    String name;
    String password;
    boolean isAuthenticate = false;

    boolean isAdmin = false;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }


    /**
     * Задание 1.
     * Метод проверяет, является ли переданное число четным или нечетным.
     *
     * @param number число
     * @return true если число четное
     */
    public boolean evenOddNumber(int number) {
        if (number % 2 == 0) {
            return true;
        }
        return false;
    }

    /**
     * Задание 2.
     * Метод проверяет, попадает ли переданное число в интервал (25;100).
     *
     * @param number число
     * @return true если число входит в интервал
     */
    public boolean numberInInterval(int number) {
        if (number >= 25 && number <= 100) {
            return true;
        }
        return false;
    }

    public boolean authenticate(String name, String password) {
        if (this.name.equals(name) && this.password.equals(password)) {
            isAuthenticate = true;
            return true;
        }
        return false;
    }

}