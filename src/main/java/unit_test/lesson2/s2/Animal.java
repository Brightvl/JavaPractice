package unit_test.lesson2.s2;

public class Animal {
    private String name;
    private int age;


    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }

    public void makeSound() {
        System.out.println(name + " makes a sound.");
    }

    // Геттеры и сеттеры для полей name и age


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Mammal extends Animal {
    public Mammal(String name, int age) {
        super(name, age);
    }

    public void giveBirth() {
        System.out.println(getName() + " gives birth to live young.");
    }
}

class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    public void layEggs() {
        System.out.println(getName() + " lays eggs.");
    }
}

