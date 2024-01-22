package JavaDevKit.lesson_5.hw5_philosopher;

import java.util.concurrent.CountDownLatch;

public class Spaghetti extends CountDownLatch{
    /**
     * Количество раз сколько поест философ
     */
    public Spaghetti(int count) {
        super(count);
    }
}
