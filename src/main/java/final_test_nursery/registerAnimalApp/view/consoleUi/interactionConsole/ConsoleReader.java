package final_test_nursery.registerAnimalApp.view.consoleUi.interactionConsole;

import java.util.List;
import java.util.Scanner;

public class ConsoleReader  implements Output, Input{

    private Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Проверяет веденные пользователем данные, являются ли они целыми числами
     *
     * @param line входная строка
     * @return boolean
     */
    public boolean checkLineOnNumbers(String line) {
        return line.matches("[0-9]+");
    }

    public String  nextLine() {
        return scanner.nextLine();
    }

    /**
     * Ввод для пользователя с сообщением
     * @param message
     * @return
     */
    public String inputln(String message) {
        System.out.println(message);
        return nextLine();
    }

    public String input(String message) {
        System.out.print(message);
        return nextLine();
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }

    public void printToyInfo() {
        System.out.printf("%-3s %-14s %-2s %-8s%n", "id", "Название", "Количество", "Вес");
    }

    public void printWonToyInfo() {
        System.out.printf("%-3s %-14s %-2s %-8s%n", "№", "Название", "Количество", "Выиграно штук");
    }

    public void print(List<String> list) {
        System.out.print(list);
    }
}
