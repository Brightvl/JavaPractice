package lesson_5.hw_5;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1) Подсчитать количество искомого слова, через map (наполнением значение, где искомое слово будет являться ключом)
 * вносить все слова не нужно
 * Пример:
 * Россия идет вперед всей планеты. Планета — это не Россия.
 * Запрос: Россия
 * Ответ: Россия - 2
 * toLoverCase().
 * (Усложнение - игнорировать пунктуацию)*
 */
public class Task1 {
    public static void main(String[] args) {
        String str = "Россия идет вперед всей планеты. Планета — это не Россия.";
        String word = "Россия";

        Map<String, Integer> map = new HashMap<>();
        String[] arr = str.replaceAll("[^a-zA-Zа-яА-Я0-9 ]", "").split("\\s+");


        System.out.println(Arrays.toString(arr));

        for (String s : arr)
            if (s.equalsIgnoreCase(word))
                map.put(s, (map.getOrDefault(s, 0) + 1));
        System.out.println(word + " - " + map.getOrDefault(word, 0));
    }
}
