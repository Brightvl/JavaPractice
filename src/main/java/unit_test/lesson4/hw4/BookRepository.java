package unit_test.lesson4.hw4;

import java.util.List;

/*
    Задание 1. Ответьте письменно на вопросы:

        1. Почему использование тестовых заглушек может быть полезным при написании модульных тестов?
            - Изолированность: Тестовые заглушки позволяют изолировать модуль, который нужно протестировать.
            - Контроль над внешними зависимостями: Заглушки позволяют контролировать поведение внешних зависимостей,
            таких как вызовы методов других классов или взаимодействие с базой данных. Это упрощает создание
             тестовых сценариев и обеспечивает стабильность тестов.
            - Ускорение тестирования: Заглушки могут заменять долгие операции, такие как взаимодействие с внешними
            ресурсами (например, сетью или базой данных), чем ускоряя выполнение тестов.

        2. Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван с
        определенными аргументами?
            - Spy. Спай (Spy) ведет учет информации о вызовах методов, такой как аргументы, и позволяет вам в
            дальнейшем проверить эти данные в целях утверждения в тесте.

        3. Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное значение или
        исключение в ответ на вызов метода?
            - Для таких случаев обычно используются заглушки (mocks). Заглушки предоставляют заранее определенные
            значения или исключения при вызове методов. Они не сохраняют информацию о вызовах, но позволяют управлять
            возвращаемыми значениями.

        4. Какой тип тестовой заглушки вы бы использовали для имитации взаимодействия с внешним API или базой данных?
            - Для имитации взаимодействия с внешним API или базой данных обычно используются фейки (fakes) или заглушки.
            Фейк представляет собой упрощенную реализацию внешнего сервиса или хранилища данных, предназначенную для
            использования в тестах. Заглушки также могут быть использованы, но они обычно более легки и
            предоставляют минимальный функционал, необходимый для тестирования.

    Задание 2.

    У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы
    данных. Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.
 */
public interface BookRepository {
    Book findById(String id);
    List<Book> findAll();
}