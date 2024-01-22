package tests.toys_shop.model.shop.raffle;



import tests.toys_shop.model.shop.goods.Toy;
import tests.toys_shop.model.shop.goods.comparators.WeightComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class ToysRaffleList<T extends Toy> {

    private PriorityQueue<Toy> toysQueue;
    private Random random;
    private ArrayList<T> copyToysList;

    public ToysRaffleList(ArrayList<T> toysList) {
        this.copyToysList = new ArrayList<>(toysList);
        this.toysQueue = new PriorityQueue<>(new WeightComparator());
        this.random = new Random();

        Collections.shuffle(copyToysList);

        for (Toy toy : copyToysList) {
            int quantity = toy.getQuantity();
            double probability = (double) toy.getWeight() / 100;
            for (int i = 0; i < quantity; i++) {
                if (random.nextDouble() <= probability) {
                    toysQueue.add(toy);
                }
            }
        }
    }

    /**
     * Добавляет игрушку в список для розыгрыша.
     *
     * @param toy класса Toy
     */
    public void add(Toy toy
    ) {
        toysQueue.add(toy);
    }

    public boolean isEmpty() {
        return !toysQueue.isEmpty();
    }

    public Toy poll() {
        return toysQueue.poll();
    }

    public PriorityQueue<Toy> getToysQueue() {
        return toysQueue;
    }

    public int raffleListSize() {
        return toysQueue.size();
    }
}
