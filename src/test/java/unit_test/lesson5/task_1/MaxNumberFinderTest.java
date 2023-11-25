package unit_test.lesson5.task_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static unit_test.lesson5.s5.task_1.MaxNumberFinder.findMaxNumber;
import static org.junit.Assert.assertEquals;

class MaxNumberFinderTest {

    List<Integer> arrayList;

    @BeforeEach
    void setUp() {
        arrayList = Arrays.asList(19,2,3,4,29,1,5,6,1);
    }

    @AfterEach
    void tearDown() {
        arrayList = null;
    }

    @Test
    void findMaxNumberTest() {
        assertEquals(29, findMaxNumber(arrayList));
    }


}