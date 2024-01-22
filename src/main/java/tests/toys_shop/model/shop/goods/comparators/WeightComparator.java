package tests.toys_shop.model.shop.goods.comparators;



import tests.toys_shop.model.shop.goods.Toy;

import java.util.Comparator;

/**
 * Класс WeightComparator реализует интерфейс Comparator для сравнения игрушек по их весу.
 * Используется для сортировки списка игрушек в классе RaffleToys.
 */
public class WeightComparator implements Comparator<Toy> {

    public int compare(Toy toy1, Toy toy2) {
        return Integer.compare(toy1.getWeight(), toy2.getWeight());
    }
}
