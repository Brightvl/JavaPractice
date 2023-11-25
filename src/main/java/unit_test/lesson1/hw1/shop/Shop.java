package unit_test.lesson1.hw1.shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
    Задание 2. (необязательное) *
    Мы хотим улучшить функциональность нашего интернет-магазина.
    Ваша задача - добавить два новых метода в класс Shop:
    Метод sortProductsByPrice(), который сортирует список продуктов по стоимости.
    Метод getMostExpensiveProduct(), который возвращает самый дорогой продукт.
    Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов,
    верное содержимое корзины).
    Напишите тесты для проверки корректности работы метода getMostExpensiveProduct. Напишите тесты для проверки
    корректности работы метода sortProductsByPrice (проверьте правильность сортировки). Используйте класс Product
    для создания экземпляров продуктов и класс Shop для написания методов сортировки и тестов.
*/
public class Shop {
    private List<Product> products;

    public Shop() {
        this.products = new ArrayList<>();
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getCost))
                .collect(Collectors.toList());
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        if (products.isEmpty()) {
            return null;
        }
        return products.stream().max(Comparator.comparing(Product::getCost)).get();
    }

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

//    public static class ArrayManipulator {
//
//        public int[] reverseArray(int[] arr) {
//            int[] reversed = new int[arr.length];
//            for (int i = 0; i < arr.length; i++) {
//                reversed[i] = arr[arr.length - 1 - i];
//            }
//            return reversed;
//        }
//    }

}