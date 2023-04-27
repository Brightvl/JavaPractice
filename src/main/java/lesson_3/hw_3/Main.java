package lesson_3.hw_3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static lesson_3.hw_3.FunctionNewObject.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Список заданий:
                1. Дан массив записей: наименование товара, цена, сорт. Найти наибольшую цену товаров 1го или 2го сорта среди товаров, название которых содержит «высший».
                2. Сведения о товаре состоят из наименования, страны-производителя, веса, цены, сорта. Получить наименования товаров заданного сорта с наименьшей ценой.
                3. Сведения о книге состоят из названия, фамилии автора, цены, года издания и количества страниц. Найти названия книг, в которых простое количество страниц, фамилия автора содержит «А» и год издания после 2010 г, включительно.
                4. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
                5*) при входном массиве, вернуть массив массивов со всеми перестановками его элементов. (со звездочкой)
                Пример входных данных:
                [1,2,3]
                Пример выходных данных:
                [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]""");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер задания -> ");
        String choice = scanner.nextLine();

        ArrayList<Product> listProduct = new ArrayList<>();
        listProduct.add(new Product("Товар_1",100,1,20,"Russia"));
        listProduct.add(new Product("Товар_2",200,2,21,"USA"));
        listProduct.add(new Product("Товар_3",100,1,15,"Greenland"));
        listProduct.add(new Product("Товар_4",150,1,14,"Germany"));
        listProduct.add(new Product("Товар_5 высший",736,2,19,"France"));
        listProduct.add(new Product("Товар_6 высший",953,1,11,"Italy"));
        listProduct.add(new Product("Товар_7",164,2,20,"Turkey"));
        listProduct.add(new Product("Товар_8 высший",964,3,12,"Australia"));

        ArrayList<Book> listBook = new ArrayList<>();
        listBook.add(new Book("Книга 1", "Иванов", 500, 2010, 100));
        listBook.add(new Book("Книга 2", "Петров", 600, 2011, 211));
        listBook.add(new Book("Книга 3", "Сидоров", 700, 2012, 300));
        listBook.add(new Book("Книга 4", "Алексеев", 800, 2013, 401));
        listBook.add(new Book("Книга 5", "Андреев", 900, 2014, 503));


        switch (choice) {
            case "1" -> {
                Product findProduct = searchMaximumPrice(listProduct);
                System.out.println("Наибольшая цена у товара: " + findProduct);
            }
            case "2" -> {
                int targetSort = 1;
                for (Product element : searchMinimumPrice(listProduct, targetSort)) {
                    System.out.printf("цена %.2f наименование %s\n", element.price, element.name);
                }
            }
            case "3" -> System.out.println(booksFilter(listBook));
            case "4" -> minMaxAverageInList(listProduct);
            case "5" -> {
                int[] numbers = {1, 2, 3, 5};
                ArrayList<ArrayList<Integer>> result = enumerationNumbersArray(numbers);
                for (ArrayList<Integer> list : result) {
                    System.out.println(Arrays.toString(list.toArray()));
                }
            }
            default -> System.out.println("Вы ввели неверное значение.");
        }
    }


}
