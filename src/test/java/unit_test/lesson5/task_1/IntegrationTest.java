package unit_test.lesson5.task_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static unit_test.lesson5.s5.task_1.MaxNumberFinder.findMaxNumber;
import static unit_test.lesson5.s5.task_1.RandomNumberGenerator.generateRandomNumbers;
import static org.junit.Assert.assertEquals;

public class IntegrationTest {
    List<Integer> integerList;

    @BeforeEach
    void setUp() {
        integerList = generateRandomNumbers(10);
    }



    @Test
    void maxNumberFinderInRandomArray() {
        System.out.println(integerList.toString());

        int maxNum = Integer.MIN_VALUE; // минимальное число / точка отсчета для цикла

        for (int i : integerList
        ) {
            if (maxNum < i) {
                maxNum = i;
            }
        }
        assertEquals(maxNum, findMaxNumber(integerList));
    }

}
