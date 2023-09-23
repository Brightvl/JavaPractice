package introductionToJava.lesson_5.hw_5;

import java.util.*;

public class Task2 {
    /**
     * 2) Пусть дан список сотрудников.
     * Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по
     * убыванию популярности.
     */


    public static void main(String[] args) {
        List<String> employees = Arrays.asList(
                "Иван Иванов", "Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов", "Петр Чернышов",
                "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова",
                "Иван Мечников", "Петр Петин", "Иван Ежов");

        Map<String, Integer> counts = new HashMap<>();

        for (String name : employees) {
            String firstName = name.split(" ")[0];
            counts.put(firstName, counts.getOrDefault(firstName, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedCounts = new ArrayList<>(counts.entrySet());
        sortedCounts.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        System.out.println("Повторяющиеся имена:");
        for (Map.Entry<String, Integer> entry : sortedCounts) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " раз(а)");
            }
        }
    }
}


