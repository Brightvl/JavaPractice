package JavaDevKit.hw_server.server;

public interface ViewServer {
    /**
     * Отобразить логи
     * @param message логи
     */
    void showLog(String message);

    /**
     * Сервер запущен
     */
    void runServer();

    /**
     * Сервер остановлен
     */
    void stopServer();

    /**
     * Отобразить уведомление
     * @param message сообщение
     */
    void showNotification(String message);
}
