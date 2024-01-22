package JavaDevKit.hw_server.server;


import JavaDevKit.hw_server.client.Client;
import JavaDevKit.hw_server.file_manager.FileManager;
import JavaDevKit.hw_server.file_manager.Manager;
import JavaDevKit.hw_server.repository.LocalRepository;
import JavaDevKit.hw_server.repository.Repository;
import JavaDevKit.hw_server.repository.User;
import JavaDevKit.hw_server.server.ui.ServerGUI;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Server {
    // адрес сервера
    private final String ipAddress = "192.168.168.255";
    private static String port = "8.8.8.8";

    // состояние
    private boolean run;

    //пути
    private final File LOG_FILE_PATH = new File("src/main/java/JavaDevKit/hw_server/file_manager/data/log.txt");
    private FileManager logger;
    private final File ALL_MESSAGE_FILE_PATH = new File("src/main/java/JavaDevKit/hw_server/file_manager/data/all_message.txt");
    private FileManager messageStorage;


    // зависимости
    private final List<Client> clients;
    private final Repository repository;
    private ViewServer viewServer;

    /**
     * Конструктор
     */
    public Server() {
        this.run = false;
        this.clients = new ArrayList<>();
        this.repository = new LocalRepository();
        this.logger = new Manager(LOG_FILE_PATH);
        this.messageStorage = new Manager(ALL_MESSAGE_FILE_PATH);
        this.viewServer = new ServerGUI(this);
    }


    /**
     * Проерка верификации пользователя
     *
     * @param ipAddress ip адрес
     * @param port      порт
     * @param login     логин
     * @param password  пароль
     * @return значение ошибки
     */
    public int checkVerification(String ipAddress, String port, String login, String password) {
        if (!ipAddress.equals(ipAddress)) return 1;
        if (!port.equals(Server.port)) return 2;
        User user = findByLogin(login);

        if (user == null) return 3;
        if (!(user.getLogin().equalsIgnoreCase(login) &&
                user.getPassword().equalsIgnoreCase(password))) return 4;
        appendMessageToServerLog("[" + login + "]: verification was successful");
        return 0;
    }

    /**
     * Поиск по логину в архиве пользователей сервера
     *
     * @param login логин
     * @return
     */
    public User findByLogin(String login) {
        for (User user : repository.getUser()
        ) {
            if (user.getLogin().equalsIgnoreCase(login)) {
                return user;
            }
        }
        return null;
    }


    /**
     * Получает сообщение отправленное клиентом и добавляет его в общий чат
     */
    public String getMessage() {
        return messageStorage.load();
    }

    /**
     * Получает сообщение отправленное клиентом и добавляет его в общий чат
     */
    public void sendMessageToGeneralChat() {
        for (Client client : clients
        ) {
            client.sendMessage(messageStorage.load());
        }

    }


    /**
     * Добавляет отправленное сообщение в логи сервера
     *
     * @param message сообщение
     */
    private void appendMessageToServerLog(String message) {
        logger.save(message);
        viewServer.showLog(logger.load());
    }

    /**
     * Добавляет пользовательское сообщение в логи сервера
     *
     * @param message сообщение
     */
    public void appendUserMessage(User user, String message) {
        appendMessageToServerLog("[" + user.getLogin() + "] sent {" + message + "} in general chat");

        messageStorage.save("[" + user.getLogin() + "]: " + message);
        sendMessageToGeneralChat();
    }

    /**
     * Действия при остановке клиента
     */
    public void stopClientGUI() {
        this.run = false;
        for (Client client : clients
        ) {
            client.disconnectedFromServer();
        }
    }

    /**
     * Добавляет клиент в список
     *
     * @param client Client
     */
    public void addClient(Client client) {
        clients.add(client);
    }

    /**
     * @return
     */
    public ServerGUI getServerGUI() {
        return (ServerGUI) viewServer;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @return Возвращает bool значение состояния сервера
     */
    public boolean isRun() {
        return run;
    }

    /**
     * Меняет значение состояния сервера
     *
     * @param run boolean
     */
    public void setRun(boolean run) {
        this.run = run;
    }

    public FileManager getLogger() {
        return logger;
    }

    /**
     * Сохраняет сообщение в логах
     *
     * @param message сообщение
     */
    public void saveInLog(String message) {
        getLogger().save(message);
    }

    /**
     * Получает сообщение из log файла
     *
     * @return сообщение
     */
    public String getLogMessage() {
        return getLogger().load();
    }
}
