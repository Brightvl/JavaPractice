package JavaCore.lesson_2;


import JavaCore.lesson_2.ui.GameProcess;

public class TicTacToeApp {

    /**
     * Метод для запуска игры.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        GameProcess gameUi = new GameProcess(5, 5, 4);
        gameUi.runGame();

    }


}
