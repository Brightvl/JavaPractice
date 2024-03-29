# Java Core

### Урок 1. Компиляция и интерпретация кода
1. Создать проект из трёх классов (основной с точкой входа и два класса в другом пакете),
которые вместе должны составлять одну программу, позволяющую производить четыре основных математических действия и осуществлять форматированный
вывод результатов пользователю (ИЛИ ЛЮБОЕ ДРУГОЕ ПРИЛОЖЕНИЕ НА ВАШ ВЫБОР, которое просто демонстрирует работу некоторого механизма).

2. Необходимо установить Docker Desktop.
Создать Dockerfile, позволяющий откопировать исходный код вашего приложения в образ для демонстрации работы вашего приложения при создании соответствующего контейнера.

### Урок 2. Данные и функции
1. Полностью разобраться с кодом программы разработанной на семинаре, переписать программу. Это минимальная задача для сдачи домашней работы.

Усложняем задачу:

2. ** Переработать метод проверки победы, логика проверки победы должна работать для поля 5х5 и
количества фишек 4. Очень желательно не делать это просто набором условий для каждой из
возможных ситуаций! Используйте вспомогательные методы, используйте циклы!

3. **** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.

### Урок 3. Классы и объекты
Построить три класса (базовый и 2 потомка), описывающих некоторых работников с почасовой оплатой (один из потомков - Freelancer) и фиксированной оплатой (второй потомок -Worker).
1.  Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
   Для «повременщиков» формула для расчета такова: «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка», для работников с фиксированной оплатой «среднемесячная заработная плата = фиксированная месячная оплата».
2. Создать на базе абстрактного класса массив/коллекцию сотрудников и заполнить его.
3. ** Реализовать интерфейсы для возможности сортировки массива/коллекции (обратите ваше внимание на интерфейсы Comparator, Comparable), добавьте новое состояние на урове базового типа и создайте свой уникальный компаратор.
4. ** Создать класс, содержащий массив или коллекцию сотрудников (как Worker так и Freelancer), и реализовать возможность вывода данных с использованием foreach (подсказка: вам потребуется поработать с интерфейсом Iterable).

### Урок 4. Обработка исключений
1. Создать программу управления банковским счетом (Account).

- Программа должна позволять пользователю вводить начальный баланс счета, сумму депозита и сумму снятия средств. При этом она должна обрабатывать следующие исключительные ситуации:
- Попытка создать счет с отрицательным начальным балансом должна вызывать исключение IllegalArgumentException с соответствующим сообщением.
- Попытка внести депозит с отрицательной суммой должна вызывать исключение IllegalArgumentException с соответствующим сообщением.
- Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать исключение InsufficientFundsException с сообщением о недостаточных средствах и текущим балансом.

Продемонстрируйте работу вашего приложения:
- Программа должна обрабатывать все исключения с помощью конструкции try-catch, выводя соответствующие сообщения об ошибках.
2. ** Создать несколько типов счетов, унаследованных от Account, например: CreditAcciunt, DebitAccount.
- Создать класс (Transaction), позволяющий проводить транзакции между счетами (переводить сумму с одного счета на другой)
- Класс Transaction должен возбуждать исключение в случае неудачной попытки перевести деньги с одного счета на другой.

Продемонстрируйте работу вашего приложения:
- Программа должна обрабатывать все исключения с помощью конструкции try-catch, выводя соответствующие сообщения об ошибках.

### Урок 5. Тонкости работы
1. Написать функцию, создающую резервную копию всех файлов в директории во вновь созданную папку ./backup
2. Доработайте класс Tree и метод print который мы разработали на семинаре. Ваш метод должен распечатать полноценное дерево директорий и файлов относительно корневой директории.
