package unit_test.lesson5.task_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static unit_test.lesson5.s5.task_1.RandomNumberGenerator.generateRandomNumbers;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    List<Integer> integerList;
    @BeforeEach
    void setUp() {
        integerList = generateRandomNumbers(10);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void generateRandomNumbersTest() {
        for (int number : integerList
        ) {
            assertTrue(number >=1 && number <= 100);
        }
    }
}