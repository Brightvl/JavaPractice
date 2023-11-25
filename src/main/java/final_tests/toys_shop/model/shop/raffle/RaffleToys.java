package final_tests.toys_shop.model.shop.raffle;


import final_tests.toys_shop.model.shop.goods.Toy;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Класс RaffleToys представляет механизм розыгрыша игрушек из магазина.
 * Он использует список всех доступных игрушек и определяет вероятность выигрыша каждой из них.
 * Когда игрушка выигрывается, она удаляется из магазина.
 * Реализует интерфейс Command и вызывает соответствующий метод в ConsoleUI для розыгрыша игрушки.
 */
public class RaffleToys<T extends Toy> {
    private ToysRaffleList<Toy> toysRaffleList;

    public RaffleToys(ArrayList<Toy> toysList) {
        this. toysRaffleList = new ToysRaffleList<>(toysList);
    }

    /**
     * Выполняет розыгрыш игрушки и возвращает выигранную игрушку.
     *
     * @return
     */
    public Toy raffleToy() {
        if (toysRaffleList.isEmpty()) {
            Toy prizeToy = toysRaffleList.poll();
            if (prizeToy != null) {
                prizeToy.setQuantity(prizeToy.getQuantity() - 1);
            }
            return prizeToy;
        }
        return null;
    }

    public void addToy(Toy toy) {
        toysRaffleList.add(toy);
    }

    public PriorityQueue<Toy> getToysQueue() {
        return toysRaffleList.getToysQueue();
    }

    @Override
    public String toString() {
        return "RaffleToys{" +
                "toysRaffleList=" + toysRaffleList +
                '}';
    }

    public int raffleListSize() {
        return toysRaffleList.raffleListSize();
    }


}


