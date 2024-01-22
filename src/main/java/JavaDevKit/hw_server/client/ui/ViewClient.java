package JavaDevKit.hw_server.client.ui;

public interface ViewClient {
    /**
     * Отображение сообщения в диалоговом окне
     * @param message сообщение
     */
    void sendMessage(String message) ;

    /**
     * Подключение к серверу
     */
    void connectedToServer();

    /**
     * Отключение от сервера
     */
    void disconnectedFromServer() ;

    /**
     * Отобразить уведомление
     * @param message сообщение
     */
    void showNotification(String message);
}
