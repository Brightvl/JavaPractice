package JavaDevKit.lesson_5.hw5_philosopher.ui;

public class Colorize {
    /**
     * Чтобы было проще различать всех
     * @param color номер цвета
     * @param s раскрашиваемая строка
     * @return раскрашенная строка
     */
    public static String stringColor(int color, String s) {
        StringBuilder stringBuilder = new StringBuilder("\u001B[" + color + "m" + s + "\u001B[0m");
        return stringBuilder.toString();

    }
}
