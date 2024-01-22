package JavaDevKit.hw_server.repository;

import java.util.List;

public interface Repository {

    /**
     * Получить пользователя
     * @return
     */
    List<User> getUser();
}
