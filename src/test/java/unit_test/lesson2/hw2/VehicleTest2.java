package unit_test.lesson2.hw2;

import unit_test.lesson2.hw2.vehicles.Car;
import unit_test.lesson2.hw2.vehicles.Motorcycle;
import unit_test.lesson2.hw2.vehicles.Vehicle;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest2 {
    private Car car;
    private Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        this.car = new Car("Honda", "Civic", 2010);
        this.motorcycle = new Motorcycle("Yamaha", "R3", 2023);
    }

    @AfterEach
    void tearDown() {
        this.car = null;
        this.motorcycle = null;
    }


    /**
     * Проверить, что экземпляр объекта Car также является экземпляром транспортного средства (используя оператор
     * instanceof).
     */
    @Test
    @DisplayName("Проверка принадлежности")
    void carInstanceTest() {
        assertInstanceOf(Vehicle.class, car);
    }

    /**
     * Проверить, что объект Car создается с 4-мя колесами.
     * <p>
     * Проверить, что объект Motorcycle создается с 2-мя колесами.
     */
    @Test
    @DisplayName("Проверка количества колес")
    void numberOfWheelsTest() {
        assertAll(
                () -> assertEquals(4, car.getNumWheels(), "Неправильное количество колес у объекта Car"),
                () -> assertEquals(2, motorcycle.getNumWheels(), "Неправильное количество колес у объекта motorcycle")
        );
    }

    /**
     * Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).
     * <p>
     * Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод testDrive()).
     */
    @Test
    @DisplayName("Проверка скорости")
    void speedTest() {
        car.testDrive();
        motorcycle.testDrive();

        assertAll(
                () -> assertEquals(60, car.getSpeed(), "Скорость объекта car неверна"),
                () -> assertEquals(75, motorcycle.getSpeed(), "Скорость объекта motorcycle неверна")
        );
    }

    /**
     * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина
     * останавливается (speed = 0).
     * <p>
     * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) мотоцикл
     * останавливается (speed = 0).
     */
    @Test
    @DisplayName("Проверка остановки")
    void parkTest() {
        car.testDrive();
        car.park();

        motorcycle.testDrive();
        motorcycle.park();

        assertAll(
                () -> assertEquals(0, car.getSpeed(), "Объект car не остановлен"),
                () -> assertEquals(0, motorcycle.getSpeed(), "Объект motorcycle не остановлен")
        );
    }

}

