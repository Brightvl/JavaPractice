package JavaCore.lesson_2.players;



import JavaCore.lesson_2.ui.GameProcess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Player {


    GameProcess gameProcess;

    public Human(GameProcess gameProcess) {
        super("NoName", 'X');
        this.gameProcess = gameProcess;
    }

    /**
     * Осуществляет ход игрока (человека), запрашивая координаты и проверяя их корректность.
     */
    public void humanTurn(Scanner scanner) {
        while (true) {
            try {
                System.out.printf("Введите координаты хода X и Y (от 1 до %d)\nчерез пробел: ",
                        gameProcess.getGameField().getFieldSizeX());

                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                super.setTurnCoordinate(x, y);
                if (!gameProcess.getGameField().isCellValid(x, y)) {
                    System.out.printf("Клетка x:%d y:%d вне диапазона\n",
                            super.getTurn().getX(),
                            super.getTurn().getY());
                } else if (!gameProcess.getGameField().isCellEmpty(x, y)) {
                    System.out.println("Клетка занята");
                } else {
                    gameProcess.getGameField().fillTurn(y, x, super.getDot());
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите целые числа.");
                scanner.nextLine(); // очистить буфер ввода
            }
        }
    }
}
