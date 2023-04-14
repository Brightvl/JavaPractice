import java.time.LocalDateTime; // Вывод даты и времени системного
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner; // запрос от пользователя данных

public class S_1 {
    // точка входа public static void main(String[] args) вся эта конструкция называется СИГНАТУРА
    // среда поняла что из этого можно собрать класс появились зеленые треугольники справа
    // public значит что метод main виден снаружи нашего класса S_1
    // static гарантирует что main моно вызывать не создавая элемент на базе класса, то есть просто поставить точку
    // после класса S_1 и вызвать main -> S_1.main
    // обязательно нужно указывать что возвращает функция(метод) как в C#, void не возвращает
    // ну в общем метод по итогу принимает в себя массив строк args это название
    public static void main(String[] args) {
        // println - вывод на экран
        //System это библиотека, out это ее внутренняя функция
        //System.out.println("Hello world");
        //print - для всех видов объектов!!
        //printf - для вывода красивой строки(через "," выводить объекты)
        //println - сразу с переносом строки так же может выводить массивы
        //быстрое написание (sout)!!!!!!!!!!!!!!!


        // Вывод даты и времени системного (now - текущая)
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);

        //String - не примитивный тип как int и тд. Это класс, поэтому с большой буквы
        String encoding = System.getProperty("console.encoding", "cp866");

        // запрос от пользователя данных не забыть импортировать сканер
        // in - ввод
        Scanner iScanner = new Scanner(System.in);
        // как в шарпе отображаем на экране
        System.out.print("Введите имя ");
        // хуярим переменную и вызываем сканер
        String name = iScanner.nextLine();
        System.out.println(name);
        // сканер закрыт и больше к нему не обратиться
        iScanner.close();
        greetings(name);
    }

    /*
    Task_1/ В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида
    "Доброе утро, <Имя>!", если время от 05:00 до 11:59
    "Добрый день, <Имя>!", если время от 12:00 до 17:59;
    "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
    "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
    */
    public static void greetings(String name) {
        LocalTime time = LocalTime.now();
        System.out.println(time);
        if (time.isAfter(LocalTime.of(5, 0)) && time.isBefore(LocalTime.of(11, 59)))
            System.out.println("Доброе утро!" + name);
        else if (time.isAfter(LocalTime.of(12, 0)) && time.isBefore(LocalTime.of(17, 59)))
            System.out.println("Добрый день!" + name);
        else if (time.isAfter(LocalTime.of(18, 0)) && time.isBefore(LocalTime.of(22, 59)))
            System.out.println("Добрый вечер!" + name);
        else System.out.println("Доброй ночи!" + name);

    }

    /*
    Дан массив двоичных чисел, например [1,1,0,1,1,1,1],
    вывести максимальное количество подряд идущих 1.
    Найти максимальное количество подряд идущих одинаковых элементов массива.
    (постараться сделать с одним циклом)
    */

    public static void maxCount(int value) {
        int count = 0;
        int maxCount = 0;
        int[] math1 = fillMath();
        for (int i = 0; i < math1.length; i++) {
            if (math1[i] == value) count++;
            if (count > maxCount) maxCount = count;
            if (math1[i] != value) count = 0;

        }
        System.out.println(maxCount);
        printMath(math1);
    }

    public static int[] fillMath() {
        // "new" - это ключевое слово по которому мы выделяем память 10 элементов. По 4 байта 40 байт
        int[] math = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            math[i] = rand.nextInt(5);
        }
        return math;
    }

    public static void printMath(int[] math) {
//        for (int i = 0; i < math.length; i++) {
//            System.out.print(math[i] + ", ");
//        }

        for (int i : math) {
            System.out.print(i + ", ");
        }
    }

    /*
    Дан массив nums = [3,2,1,2,3] и число val = 3.
    Если в массиве есть числа, равные заданному,
    нужно перенести эти элементы в конец массива.
    Таким образом, первые несколько (или все) элементов
    массива должны быть отличны от заданного, а остальные - равны ему.
    [2,2,1,3,3]
    [2,1,2,3,3]
    */
}




