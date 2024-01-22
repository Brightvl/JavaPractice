package JavaDevKit.hw_server.client;


import JavaDevKit.hw_server.client.ui.ViewClient;
import JavaDevKit.hw_server.repository.User;
import JavaDevKit.hw_server.server.Server;

public class Client {
    private ViewClient view;
    private Server server;

    // пользователь управляющий клиентом
    private User user;

    //пройдена ли авторизация
    private boolean authorized;

    /**
     * Constructor
     * @param view the view
     * @param server the server
     */
    public Client(ViewClient view, Server server) {
        this.view = view;
        this.server = server;

        this.authorized = false;
    }

    /**
     * Включает сервер для Ui
     */
    private void connectToServer() {
        view.connectedToServer();
    }

    /**
     * Выключает сервер для Ui
     */
    public void disconnectedFromServer() {
        view.disconnectedFromServer();
    }

    /**
     * Выводит сообщение в диалоговое окно
     * @param message сообщение от view
     */
    public void sendMessage(String message) {
        view.sendMessage(message);
    }

    /**
     * Получает сообщение от сервера
     * @return сообщение сервера
     */
    public String getMessage() {
        return server.getMessage();
    }

    /**
     * Сообщение полученное от пользователя, передает серверу
     * @param message сообщение
     */
    public void appendMessage(String message) {
        server.appendUserMessage(this.user,message);
    }


    /**
     * Проверяет верификацию введенных данных пользователя у сервера
     *
     * @param ip       Ip адрес
     * @param port     порт
     * @param login    логин
     * @param password пароль
     */
    public void checkVerification(String ip, String port, String login, String password) {
        if (checkServerStartup()) {
            int verificationLog = server.checkVerification(ip, port, login, password);
            switch (verificationLog) {
                case 1 -> {
                    view.showNotification("Ip адрес не найден");
                }
                case 2 -> {
                    view.showNotification("Неверно указанный порт");
                }
                case 3 -> {
                    view.showNotification("Для авторизации введите логин и пароль");
                }
                case 4 -> {
                    view.showNotification("Не верный логин или пароль");
                }
                default -> {
                    this.user = server.findByLogin(login);
                    this.authorized = true;
                    server.addClient(this);
                    connectToServer();
                }
            }
        } else view.showNotification("Сервер не запущен");
    }


    //region getters and setters
    public boolean checkServerStartup() {
        return server.isRun();
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public String getIp() {
        return server.getIpAddress();
    }
    //endregion


}
