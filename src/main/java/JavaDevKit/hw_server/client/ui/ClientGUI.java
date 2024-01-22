package JavaDevKit.hw_server.client.ui;




import JavaDevKit.hw_server.client.Client;
import JavaDevKit.hw_server.client.ui.widgets.MessageDisplayWindowPanel;
import JavaDevKit.hw_server.client.ui.widgets.SendMessagePanel;
import JavaDevKit.hw_server.client.ui.widgets.VerificationPanel;
import JavaDevKit.hw_server.server.Server;

import javax.swing.*;
import java.awt.*;

public class ClientGUI extends JFrame implements ViewClient {

    //region Поля
    // размеры окна
    private static final int WIDTH = 400;
    private static final int HEIGHT = 507;

    // виджеты
    private final MessageDisplayWindowPanel messageDisplayWindowPanel;
    private final JPanel mainPanel;

    //зависимости
    private Client client;
    //endregion


    //region Конструктор
    /**
     * Конструктор
     * @param server сервер
     */
    private ClientGUI(Server server) {
        this.client = new Client(this, server);

        //виджеты
        this.mainPanel = new JPanel(new BorderLayout(2, 1));
        this.messageDisplayWindowPanel = new MessageDisplayWindowPanel(this);

        // задаем параметры окна
        getSettingWindow();
        //выводит панель верификации
        clientUpdate();
    }

    /**
     * Задает параметры клиентского окна
     */
    private void getSettingWindow() {
        setTitle("General chat"); // название окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false); // запрет на растягивание окна
    }

    /**
     * Фабричный метод для создания объекта и отображения окна
     */
    public static void createClientGUI(Server server, Point pointWindow, int indentX, int indentY) {
        // Создаем новое окно клиента
        ClientGUI clientGUI = new ClientGUI(server);
        // сдвиг окна клиента относительно координат
        int x = (int) pointWindow.getX();
        int y = (int) pointWindow.getY();
        clientGUI.setLocation(x + indentX, y + indentY);
        clientGUI.setVisible(true);
    }
    //endregion

    /**
     * Логика GUI
     */
    public void clientUpdate() {
        if (client.checkServerStartup()) {
            if (!client.isAuthorized()) {
                createVerificationPanel();
            } else createChatField();

        } else {
            if (client.isAuthorized()) {
                showNotification("Server is not responding");
                client.setAuthorized(false);
            }
            createVerificationPanel();
        }
    }

    /**
     * Создает поле для ввода верификационных параметров пользователя
     */
    private void createVerificationPanel() {
        this.mainPanel.removeAll(); // Очищаем текущие компоненты
        //widgets
        VerificationPanel verificationPanel = new VerificationPanel(this);
        this.mainPanel.add(verificationPanel, BorderLayout.NORTH);

        add(mainPanel);
        revalidate(); // Обновляем компоненты окна
        repaint();
    }

    /**
     * Создание окна чата и ввода сообщения
     */
    private void createChatField() {
        this.mainPanel.removeAll(); // Очищаем текущие компоненты
        this.mainPanel.add(messageDisplayWindowPanel, BorderLayout.CENTER);

        add(mainPanel);

        SendMessagePanel sendMessagePanel = new SendMessagePanel(this);
        add(sendMessagePanel, BorderLayout.SOUTH);

        revalidate(); // Обновляем компоненты окна
        repaint();
    }

    /**
     * Принимает сообщение от клиента
     * @return сообщение
     */
    public String getMessage() {
        return client.getMessage();
    }

    /**
     * Передает сообщение клиенту
     * @param message сообщение
     */
    public void appendMessage(String message) {
        client.appendMessage(message);
    }

    /**
     * Выдает уведомление
     * @param message сообщение
     */
    @Override
    public void showNotification(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * Отображение сообщения в диалоговом окне
     * @param message сообщение
     */
    @Override
    public void sendMessage(String message) {
        messageDisplayWindowPanel.sendMessage(message);
    }

    /**
     * Подключение к серверу
     */
    @Override
    public void connectedToServer() {
        clientUpdate();
    }

    /**
     * Отключение от сервера
     */
    @Override
    public void disconnectedFromServer() {
        clientUpdate();
    }

    /**
     * Принимает Ip адрес от сервера
     * @return строка
     */
    public String getIp() {
        return client.getIp();
    }

    /**
     * Передает введенные параметры авторизации клиенту
     * @param ipAddress адресс
     * @param port порт
     * @param login логин
     * @param password пароль
     */
    public void verification(String ipAddress, String port, String login, String password) {
        client.checkVerification(ipAddress,port,login,password);
    }

}
