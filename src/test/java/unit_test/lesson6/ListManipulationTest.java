package unit_test.lesson6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import unit_test.lesson6.ListManipulation;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListManipulationTest {
    ListManipulation listManipulation;

    @BeforeEach
    void setUp() {
        listManipulation = new ListManipulation();
    }

    @AfterEach
    void tearDown() {
        listManipulation = null;
    }


    @Test
    @DisplayName("Проверка правильности сравнения средних значений")
    void averageListTest() {
        List<Double> doubleList1 = Arrays.asList(1.0, 2.0, 3.0, 6.0);
        assertEquals(3.0, listManipulation.averageList(doubleList1));
    }

    @Test
    @DisplayName("Проверка возвращаемых сообщений при сравнения средних значений")
    void compareAverageNumberListTest() {

        List<Double> referenceList = Arrays.asList(1.0, 2.0, 3.0, 6.0);
        assertEquals("Средние значения равны",
                listManipulation.compareAverageNumberList(referenceList, referenceList));
        List<Double> doubleList1 = Arrays.asList(1.0, 2.0, 3.0, 5.0);
        assertEquals("Первый список имеет большее среднее значение",
                listManipulation.compareAverageNumberList(referenceList, doubleList1));
        List<Double> doubleList2 = Arrays.asList(1.0, 2.0, 3.0, 7.0);
        assertEquals("Второй список имеет большее среднее значение",
                listManipulation.compareAverageNumberList(referenceList, doubleList2));
    }
}