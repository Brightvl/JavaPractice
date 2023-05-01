package lesson_3.hw_3;

import java.util.ArrayList;

import static lesson_2.hw_2.sequence.T1_SumPrimeNumber.IsPrimeNumber;


public class FunctionNewObject {

    /**
     * Task_1. Дан массив записей: наименование товара, цена, сорт. Найти наибольшую цену товаров 1-го или 2-го сорта
     * среди товаров, название которых содержит «высший».
     *
     * @param productList принимается лист с типами данных Product
     */
    public static Product searchMaximumPrice(ArrayList<Product> productList) {
        double maxPrice = 0;
        int resultPrise = 0;
        for (int i = 0; i < productList.size(); i++) {
            Product element = productList.get(i);
            if (element.variety == 1 || element.variety == 2 && element.name.contains("высший")) {
                if (element.price > maxPrice) {
                    maxPrice = element.price;
                    resultPrise = i;
                }
            }
        }
        return productList.get(resultPrise);
    }

    /**
     * Task2. Сведения о товаре состоят из наименования, страны-производителя, веса, цены, сорта. Получить
     * наименования товаров заданного сорта с наименьшей ценой.
     *
     * @param productList принимается лист с типами данных Product
     * @param variety     принимает сорт товара
     * @return Возвращает список найденных товаров соответсвующий фильтру
     */
    public static ArrayList<Product> searchMinimumPrice(ArrayList<Product> productList, int variety) {
        ArrayList<Product> newProductList = new ArrayList<>();
        double minPrice = Double.MAX_VALUE;
        for (Product element : productList) {
            if (element.variety == variety && element.price <= minPrice) {
                if (element.price < minPrice) {
                    newProductList = new ArrayList<>();
                    minPrice = element.price;
                }
                newProductList.add(element);
            }
        }
        return newProductList;
    }

    /**
     * Task_3. Сведения о книге состоят из названия, фамилии автора, цены, года издания и количества страниц. Найти
     * названия книг, в которых простое количество страниц, фамилия автора содержит «А» и год издания после 2010 г,
     * включительно.
     *
     * @param booksList принимает список с данными о книгах
     * @return возвращает список с типом Book
     */
    public static ArrayList<Book> booksFilter(ArrayList<Book> booksList) {
        ArrayList<Book> newBooksList = new ArrayList<>();
        for (Book element : booksList) {
            if (IsPrimeNumber(element.numberPages) && element.surname.contains("А") && element.yearPublication > 2010) {
                newBooksList.add(element);
            }
        }
        return newBooksList;
    }

    /**
     * Task_4. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
     *
     * @param productList данные списка товаров(использовал вес)
     */
    public static void minMaxAverageInList(ArrayList<Product> productList) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        double difference1 = Double.MAX_VALUE;
        int averageNum = 0;

        for (Product element : productList) {
            if (element.weight > maxValue) maxValue = element.weight;
            if (element.weight < minValue) minValue = element.weight;
        }

        double average = (double) (maxValue + minValue) / 2;
        for (Product element : productList) {
            double difference2 = Math.abs(average - element.weight);
            if (difference1 > difference2) {
                difference1 = difference2;
                averageNum = element.weight;
            }
        }
        System.out.println("Данные взял из веса объекта Product");
        System.out.println("Минимальное значение -> " + minValue);
        System.out.println("Среднее арифметическое списка -> " + average);
        System.out.println("Среднее число из списка -> " + averageNum);
        System.out.println("Максимальное значение -> " + maxValue);
    }

    /**
     * 5*) при входном массиве, вернуть массив массивов со всеми перестановками его элементов. (со звездочкой)
     * Пример входных данных:
     * [1,2,3]
     * Пример выходных данных
     * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *

     * @param nums принимает массив целых чисел
     * @return список списков с целыми числами
     */
    public static ArrayList<ArrayList<Integer>> enumerationNumbersArray(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        recursiveFill(nums, 0, result);
        return result;
    }

    /**
     * Рекурсивная функция для генерации всех перестановок. Внутри перебираем все элементы массива и меняем их местами
     * @param nums массив с целыми числами
     * @param start для точки перестановок. Если start больше или равен длине массива, добавляем текущую перестановку в
     *             результат
     * @param result после всех процедур итоговый список списков
     */
    private static void recursiveFill(int[] nums, int start, ArrayList<ArrayList<Integer>> result) {

        if (start >= nums.length) {
            ArrayList<Integer> item = convertArrayToList(nums);
            result.add(item);
        }
        for (int j = start; j <= nums.length - 1; j++) {
            swap(nums, start, j);
            recursiveFill(nums, start + 1, result);
            swap(nums, start, j);
        }
    }

    /**
     * Функция для преобразования массива в ArrayList
     * @param num принимает массив чисел
     * @return ArrayList<Integer>
     */
    private static ArrayList<Integer> convertArrayToList(int[] num) {
        ArrayList<Integer> item = new ArrayList<>();
        for (int h : num) {
            item.add(h);
        }
        return item;
    }

    /**
     * Функция для обмена элементов массива
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



}




