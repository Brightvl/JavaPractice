package JavaIntro.lesson_2.seminar_2;

/**
 * 3) Дан массив целых чисел. Найти количество пар соседних элементов,
 * где первый элемент вдвое больше второго.
 */
public class Task_3 {
    public static void main(String[] args) {
        int[] arrayNumber = {4, 2, 20, 10, 5, 3, 8, 4, 8, 4, 8, 4, 8, 4};
        System.out.println(FirstMoreSecond(arrayNumber));

    }

    public static int FirstMoreSecond(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == 2 * array[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
