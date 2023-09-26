package ExeptionsSeminars.S3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class S3 {
    public static void main(String[] args) throws IOException {

        {//#1
            rwLine(Path.of("132.TXT"), Path.of("321"));
            try {
                doSomething(true);
            } catch (IOException e) {
                System.out.println("Обработка исключения");
            }
        }

        {//#2
            try (Counter counter = new Counter()) {
                System.out.println(counter);
                counter.add();
                System.out.println(counter);
                counter.close();
                System.out.println(counter);
                counter.add();
            } catch (NullPointerException e) {
                System.out.println("Close Убери!");
            }
        }

        {//#3
            try {
                int i = 7 / 0;
            } catch (RuntimeException e) {
                throw new MyException();
            }
        }

        {//#4
            try {
                Integer[] arr = new Integer[]{1, 2, 3, null, 5};
                arr[3]++;
            } catch (NullPointerException npe) {
                throw new ExceptionEmptyElement();
            }
        }

        {//#5
            String path = "133.TXT";
            try (FileReader fileReader = new FileReader(path)) {
            } catch (IOException e) {
                throw new FileDoesNotExistException(path);
            }
        }

        {//#6
            System.out.println(Ex(new String[][]
                    {
                            {"6", "4", "3", "2"},
                            {"5", "6", "4", "8"},
                            {"4", "5", "6", "6"},
                            {"7", "6", "5", "2"}
                    }));
        }
    }

    /**
     * Просто нужно было исправить код
     */
    public static void rwLine(Path pathRead, Path pathWrite) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(pathRead); BufferedWriter out = Files.newBufferedWriter(pathWrite)) {
            out.write(in.readLine());
        }
    }


    /**
     * Создайте метод doSomething(), который может быть источником одного из
     * типов checked exceptions (тело самого метода прописывать не обязательно).
     * Вызовите этот метод из main и обработайте в нем исключение, которое
     * вызвал метод doSomething().
     */
    private static void doSomething(boolean fail) throws IOException {
        if (fail) {
            throw new IOException();
        }
    }

    /**
     * Напишите метод, на вход которого подаётся двумерный строковый массив
     * размером 4х4. При подаче массива другого размера необходимо бросить
     * исключение MyArraySizeException.
     */
    private static int Ex(String[][] strArr) {
        if (strArr.length != 4 || strArr[0].length != 4) {
            throw new MyArraySizeException();
        }
        return sumArray(strArr);
    }

    /**
     * Далее метод должен пройтись по всем элементам массива, преобразовать в
     * int и просуммировать. Если в каком-то элементе массива преобразование
     * не удалось (например, в ячейке лежит символ или текст вместо числа),
     * должно быть брошено исключение MyArrayDataException с детализацией, в
     * какой именно ячейке лежат неверные данные.
     */
    private static int sumArray(String[][] strArr) {
        int result = 0;

        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[0].length; j++) {
                try {
                    result += Integer.parseInt(strArr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return result;
    }
}

/**
 * Создайте класс Счетчик, у которого есть метод add(), увеличивающий
 * значение внутренней int переменной на 1. делайте так, чтобы с объектом
 * такого типа можно было работать в блоке try-with-resources. Нужно бросить
 * исключение, если работа с объектом типа счетчик была не в ресурсном try
 * и/или ресурс остался открыт. Подумайте какой тип исключения подойдет
 * лучше всего.
 */
class Counter implements Closeable {

    private Integer number = 0;

    public void add() {
        this.number++;
    }

    @Override
    public void close() {
        this.number = null;
    }

    @Override
    public String toString() {
        return "Counter{" + "number=" + number + '}';
    }
}

/**
 * Создайте класс исключения, который будет выбрасываться при делении на
 * 0. Исключение должно отображать понятное для пользователя сообщение
 * об ошибке.
 */
class MyException extends RuntimeException {

    public MyException() {
        super("Нельзя делить на 0 целые числа");
    }
}

/**
 * Создайте класс исключений, которое будет возникать при обращении к
 * пустому элементу в массиве ссылочного типа. Исключение должно
 * отображать понятное для пользователя сообщение об ошибке
 */
class ExceptionEmptyElement extends NullPointerException {

    public ExceptionEmptyElement() {
        super("Значение элемента массива не может быть nullевым");
    }
}

/**
 * Создайте класс исключения, которое будет возникать при попытке открыть
 * несуществующий файл. Исключение должно отображать понятное для
 * пользователя сообщение об ошибке.
 */
class FileDoesNotExistException extends IOException {

    public FileDoesNotExistException(String path) {
        super(path + " -> По указанному пути файл не найден");
    }

}


/**
 * Напишите метод, на вход которого подаётся двумерный строковый массив
 * размером 4х4. При подаче массива другого размера необходимо бросить
 * исключение MyArraySizeException.
 */
class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Ваша матрица не квадрат");
    }
}

/**
 * Создайте класс Счетчик, у которого есть метод add(), увеличивающий
 * значение внутренней int переменной на 1. делайте так, чтобы с объектом
 * такого типа можно было работать в блоке try-with-resources. Нужно бросить
 * исключение, если работа с объектом типа счетчик была не в ресурсном try
 * и/или ресурс остался открыт. Подумайте какой тип исключения подойдет
 * лучше всего.
 */
class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i, int j) {
        super(String.format("Неправильный элемент на месте %d:%d", i, j));
    }
}