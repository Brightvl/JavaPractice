package JavaDevKit.hw_server.repository;

public class User {

    private final String login;
    private final String password;


    public User(String name, String password) {
        this.login = name;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}



