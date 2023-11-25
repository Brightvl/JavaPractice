package unit_test.lesson1.hw1.shop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit_test.lesson1.hw1.shop.Product;
import unit_test.lesson1.hw1.shop.Shop;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    private Shop shop;

    @BeforeEach
    void setUp() {
        this.shop = new Shop();
    }

    @AfterEach
    void tearDown() {
        this.shop = null;
    }

    // проверка метода testSortProductsByPrice
    @Test
    void testSortProductsByPrice() {
        Product product1 = new Product("Product 1", 100);
        Product product2 = new Product("Product 2", 50);
        Product product3 = new Product("Product 3", 75);

        shop.addProduct(product3);
        shop.addProduct(product2);
        shop.addProduct(product1);

        assertEquals(new ArrayList<Product>() {{
            add(product2);
            add(product3);
            add(product1);
        }}, shop.sortProductsByPrice());

//        assertIterableEquals(new ArrayList<Product>() {{ // порядок не важен в этом методе
//            add(product2);
//            add(product3);
//            add(product1);
//        }}, shop.sortProductsByPrice());
    }

    @Test
    public void testSortProductsByPriceEmptyList() {
        List<Product> sortedProducts = shop.sortProductsByPrice();
        assertTrue(sortedProducts.isEmpty());
    }

    // проверка метода GetMostExpensiveProduct()
    @Test
    public void testGetMostExpensiveProduct() {
        shop.addProduct(new Product("Product 1", 100));
        shop.addProduct(new Product("Product 2", 50));
        shop.addProduct(new Product("Product 3", 75));
        Product product = new Product("mostExpensive", Integer.MAX_VALUE);
        shop.addProduct(product);
        Product mostExpensiveProduct = shop.getMostExpensiveProduct();
        assertEquals(mostExpensiveProduct, product);
    }

    @Test
    public void testGetMostExpensiveProductEmptyList() {
        assertNull(shop.getMostExpensiveProduct());
    }


//    @Test
//    void testReverseArray() {
//        // Создаем объект ArrayManipulator
//        Shop.ArrayManipulator arrayManipulator = new Shop.ArrayManipulator();
//
//        // Создаем исходный массив
//        int[] originalArray = {1, 2, 3, 4, 5};
//
//        // Вызываем метод reverseArray для переворота массива
//        int[] reversedArray = arrayManipulator.reverseArray(originalArray);
//
//        // Ожидаемый результат - массив, в котором элементы перевернуты
//        int[] expectedArray = {5, 4, 3, 2, 1};
//
//        // Используем assertArrayEquals для сравнения двух массивов
//        assertArrayEquals(expectedArray, reversedArray);
//    }

}
