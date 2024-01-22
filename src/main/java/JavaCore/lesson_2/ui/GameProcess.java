package JavaCore.lesson_2.ui;


import JavaCore.lesson_2.field.GameField;
import JavaCore.lesson_2.mechanics.GameState;
import JavaCore.lesson_2.players.Bot;
import JavaCore.lesson_2.players.Human;
import JavaCore.lesson_2.players.Player;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Класс отвечает за управление игровым процессом, включая ходы игроков, отображение игрового интерфейса и обработку
 * состояний игры.
 */
public class GameProcess {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    private GameField gameField;
    private GameState gameState;

    private Colorer colorer;
    private Human human;
    private Bot bot;

    private boolean gameRun;


    /**
     * Конструктор класса
     *
     * @param widthField  Ширина игрового поля.
     * @param heightField Высота игрового поля.
     * @param winCount    Количество символов для победы.
     */
    public GameProcess(int widthField, int heightField, int winCount) {
        this.gameField = new GameField(widthField, heightField);
        this.gameState = new GameState(gameField, winCount);

        this.colorer = new Colorer();
        this.human = new Human(this);
        this.bot = new Bot(this);

        this.gameRun = true;

    }

    /**
     * Запускает игру
     */
    public void runGame() {
        menuWelcome();
        gameUi();
    }

    /**
     * Приветствие при первом входе
     */
    private void menuWelcome() {
        System.out.println("""
                Крестики-нолики!
                                
                Введи свое имя:
                """);
        human.setName(scanner.next());
        choiceDifficulty();
    }


    /**
     * Отображает игровой процесс, включая ходы игроков и проверку состояния игры.
     */
    private void gameUi() {
        gameField.initialize(); // Инициализация доски
        System.out.println("Игрок: " + colorer.stringColor(31, human.getName()));
        gameField.printField(); // Отрисовка

        while (gameRun) {
            gameProcess(); // запуск игрового процесса

            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("Н")) {
                System.out.println("Сменить уровень сложности? (Y - да): ");
                choice = scanner.next();
                if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("Н")) {
                    choiceDifficulty();
                }
                gameField.initialize();
                gameField.printField();

            } else {
                scanner.close();
                this.gameRun = false;
            }
        }
    }

    /**
     * Запускает игровой процесс
     */
    private void gameProcess() {
        while (true) {
            humanTurn(); // ход игрока
            System.out.println(showNameAndCoordinate(human));
            gameField.printField();
            if (gameState.checkGameState(human.getTurn().getX(), human.getTurn().getY(),
                    human.getDot(), human.getName() + ", вы победили!")) {
                break;
            }
            botTurn(); // ход бота
            System.out.println(showNameAndCoordinate(bot));
            gameField.printField();
            if (gameState.checkGameState(bot.getTurn().getX(), bot.getTurn().getY(),
                    bot.getDot(), "Победил " + bot.getName()))
                break;
        }
    }

    private String showNameAndCoordinate(Player player) {
        return "Игрок: " + player.getName() +
                ", метка x:" + (player.getTurn().getX() + 1) +
                " y:" + (player.getTurn().getY() + 1);
    }

    /**
     * Осуществляет ход игрока (человека)
     */
    private void humanTurn() {
        human.humanTurn(scanner);
    }

    /**
     * Осуществляет ход игрока (компьютера)
     */
    private void botTurn() {
        bot.botTurn(human, random);
    }

    public GameField getGameField() {
        return gameField;
    }

    public GameState getGameState() {
        return gameState;
    }


    /**
     * Выбор сложности
     */
    private boolean choiceDifficulty() {
        System.out.println("""
                Уровень сложности компьютера:
                1. Глупая железяка
                2. Кажется у него есть разум
                3. Доставит трудности
                Введите номер: """);
        try {
            int choice = scanner.nextInt() - 1;
            if (choice < 0 || choice > 2) {
                System.out.printf("Вы не ввели число из диапазона\nСтандартный уровень сложности: %s\n",
                        showDifficult());
            } else {
                bot.choiceDifficulty(choice);
                System.out.printf("Выбрана сложность: %s\n", showDifficult());
                return true;
            }
        } catch (InputMismatchException e) {
            System.out.printf("Вы не ввели целое число!\nСтандартный уровень сложности: %s\n", showDifficult());
            scanner.nextLine(); // очистить буфер ввода
        }
        return false;
    }

    /**
     * @return уровень сложности текстом
     */
    private String showDifficult() {
        String difficult;
        switch (bot.getLevelBot()) {
            case 0 -> {
                difficult = "Глупая железяка";
            }
            case 2 -> {
                difficult = "Доставит трудности";
            }
            default -> {
                difficult = "Кажется у него есть разум";
            }
        }
        return difficult;
    }
}

