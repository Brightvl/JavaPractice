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
    public static Product SearchMaximumPrice(ArrayList<Product> productList) {
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
     * Task_2. Сведения о товаре состоят из наименования, страны-производителя, веса, цены, сорта. Получить
     * наименования товаров заданного сорта с наименьшей ценой.
     *
     * @param productList принимается лист с типами данных Product
     * @param variety     принимает сорт товара
     * @return Возвращает список найденных товаров соответсвующий фильтру
     */
    public static ArrayList<Product> SearchMinimumPrice(ArrayList<Product> productList, int variety) {
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
    public static ArrayList<Book> BooksFilter(ArrayList<Book> booksList) {
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
     * @param productList данные списка товаров(использовал вес)
     */
    public static void MinMaxAverageInList(ArrayList<Product> productList) {
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


}




