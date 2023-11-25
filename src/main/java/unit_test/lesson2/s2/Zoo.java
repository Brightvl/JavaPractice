package unit_test.lesson2.s2;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        // Создаем разных животных
        Mammal lion = new Mammal("Lion", 5);
        Mammal elephant = new Mammal("Elephant", 10);
        Bird eagle = new Bird("Eagle", 3);

        // Добавляем животных в список
        animals.add(lion);
        animals.add(eagle);
        animals.add(elephant);

        // Вызываем разные методы для животных
        for (Animal animal : animals) {
            animal.eat();
            animal.makeSound();
            animal.sleep();
            if (animal instanceof Mammal) {
                ((Mammal) animal).giveBirth();
            } else if (animal instanceof Bird) {
                ((Bird) animal).layEggs();
            }
            System.out.println();
        }
    }
}
