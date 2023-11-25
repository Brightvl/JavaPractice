package unit_test.lesson2.hw2;

import unit_test.lesson2.hw2.vehicles.Car;
import unit_test.lesson2.hw2.vehicles.Motorcycle;
import unit_test.lesson2.hw2.vehicles.Vehicle;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Задание 1.
 * Проект Vehicle. Написать тесты с использованием JUnit5:
 */
public class VehicleTest {

    @Nested
    class CarTest {
        private Car car;

        @BeforeEach
        void setUp() {
            this.car = new Car("Honda", "Civic", 2010);
        }

        @AfterEach
        void tearDown() {
            this.car = null;
        }


        /**
         * Проверить, что экземпляр объекта Car также является экземпляром транспортного средства (используя оператор
         * instanceof).
         */
        @Test
        @DisplayName("Проверка принадлежности Car к Vehicle")
        void carInstanceTest() {
            assertInstanceOf(Vehicle.class, car);
        }

        /**
         * Проверить, что объект Car создается с 4-мя колесами.
         */
        @Test
        @DisplayName("Проверка количества колес")
        void numberOfWheelsTest() {
            assertEquals(4, car.getNumWheels());
        }


        /**
         * Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).
         */
        @Test
        @DisplayName("Проверка скорости 60")
        void speedTest() {
            car.testDrive();
            assertEquals(60, car.getSpeed());
        }

        /**
         * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина
         * останавливается (speed = 0).
         */
        @Test
        @DisplayName("Проверка остановки")
        void parkTest() {
            car.testDrive();
            car.park();
            assertEquals(0, car.getSpeed());
        }
    }

    @Nested
    class MotorcycleTest {

        private Motorcycle motorcycle;

        @BeforeEach
        void setUp() {
            this.motorcycle = new Motorcycle("Yamaha", "R3", 2023);
        }

        @AfterEach
        void tearDown() {
            this.motorcycle = null;
        }

        /**
         * Проверить, что объект Motorcycle создается с 2-мя колесами.
         */
        @Test
        @DisplayName("Проверка количества колес")
        void numberOfWheelsTest() {
            assertEquals(2, motorcycle.getNumWheels());
        }

        /**
         * Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод testDrive()).
         */
        @Test
        @DisplayName("Проверка скорости 75")
        void speedTest() {
            motorcycle.testDrive();
            assertEquals(75, motorcycle.getSpeed());
        }

        /**
         * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) мотоцикл
         * останавливается (speed = 0).
         */
        @Test
        @DisplayName("Проверка остановки")
        void parkTest() {
            motorcycle.testDrive();
            motorcycle.park();
            assertEquals(0, motorcycle.getSpeed());
        }

    }
}