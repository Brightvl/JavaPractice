package final_tests.toys_shop.model.shop.goods;



import java.io.Serializable;

/**
 * Класс Toy представляет игрушку в магазине.
 * Каждая игрушка имеет уникальный идентификатор, название, количество и вес.
 * Реализует интерфейс Serializable для возможности сериализации объектов этого класса.
 */
public class Toy implements Serializable, Comparable<Toy>{

    private static int counter = 1;
    private int id;
    private String name;
    private int quantity;
    private int weight;

    public Toy(String name, int quantity, int weight) {
        this.id = counter++;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public static void setCounter(int counter) {
        Toy.counter = counter;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%-3d %-14s %-10d %d", id, name, quantity, weight);
    }

    @Override
    public int compareTo(Toy o) {
        return Integer.compare(this.weight, o.weight);
    }
}
