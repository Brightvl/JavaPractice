package unit_test.lesson2.s2;

import org.junit.jupiter.api.Test;
import unit_test.lesson2.s2.Animal;
import unit_test.lesson2.s2.Bird;
import unit_test.lesson2.s2.Mammal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZooTest {

    @Test
    void testZooBehavior() {
        // Создаем новый поток вывода
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Создаем список животных
        List<Animal> animals = new ArrayList<>();
        animals.add(new Mammal("Lion", 5));
        animals.add(new Bird("Eagle", 3));
        animals.add(new Mammal("Elephant", 10));

        // Перебираем животных и вызываем их методы
        for (Animal animal : animals) {
            animal.eat();
            animal.makeSound();
            animal.sleep();
            if (animal instanceof Mammal) {
                ((Mammal) animal).giveBirth();
            } else if (animal instanceof Bird) {
                ((Bird) animal).layEggs();
            }
            System.out.println(); // Добавляем пустую строку для разделения вывода
        }

        // Ожидаемый вывод в консоль
        // не знаю в чем прикол, но после замены /n на System.lineSeparator() код сразу заработал
        String expectedOutput = "Lion is eating." + System.lineSeparator() +
                "Lion makes a sound." + System.lineSeparator() +
                "Lion is sleeping." + System.lineSeparator() +
                "Lion gives birth to live young." + System.lineSeparator() +
                System.lineSeparator() +
                "Eagle is eating." + System.lineSeparator() +
                "Eagle makes a sound." + System.lineSeparator() +
                "Eagle is sleeping." + System.lineSeparator() +
                "Eagle lays eggs." + System.lineSeparator() +
                System.lineSeparator() +
                "Elephant is eating." + System.lineSeparator() +
                "Elephant makes a sound." + System.lineSeparator() +
                "Elephant is sleeping." + System.lineSeparator() +
                "Elephant gives birth to live young." + System.lineSeparator()+ System.lineSeparator();

        // Сравниваем фактический вывод с ожидаемым
        assertEquals(expectedOutput, outputStream.toString());

        // Восстанавливаем стандартный вывод
        System.setOut(System.out);

    }

    @Test
    void testAnimalAges() {
        // Создаем список животных
        List<Animal> animals = new ArrayList<>();
        animals.add(new Mammal("Lion", 5));
        animals.add(new Bird("Eagle", 3));
        animals.add(new Mammal("Elephant", 10));

        // Проверяем, что возраст каждого животного равен ожидаемому
        assertEquals(5, animals.get(0).getAge());
        assertEquals(3, animals.get(1).getAge());
        assertEquals(10, animals.get(2).getAge());
    }
}