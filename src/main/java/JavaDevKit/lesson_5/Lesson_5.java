package JavaDevKit.lesson_5;

/*
В рамках выполнения задачи необходимо:
    Создать два класс ObjectA, ObjectB
    Реализовать класс в котором два потока при запуске провоцируют DeadLock для объектов ObjectA, ObjectB
 */
/*
В рамках выполнения задачи необходимо:
    Создайте два потока A и B.
    Поток A меняет значение Boolean переменной switcher с задержкой 1000 миллисекунд
    (true в состояние false и наоборот).
    Поток B ожидает состояния true переменной switcher и выводит на консоль обратный отсчет от 100
    с задержкой 100 миллисекунд и приостанавливает свое действие, как только поток A переключит switcher
    в состояние false.
    Условием завершения работы потоков является достижение отсчета нулевой отметки.
    Можно воспользоваться синхронизацией для управления значения переменной или volatile
 */

import java.util.concurrent.CountDownLatch;

/*
В рамках выполнения задачи необходимо:
    3 бегуна должны прийти к старту гонки
    Программа должна гарантировать, что гонка начнется только когда все три участника будут на старте
    Программа должна отсчитать “На старт”, “Внимание”, “Марш”
    Программа должна завершиться когда все участники закончат гонку.
    Подумайте об использовании примитива синхронизации
 */
public class Lesson_5 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(4);
        Runner runner1 = new Runner(cdl, "first");
        Runner runner2 = new Runner(cdl, "second");
        Runner runner3 = new Runner(cdl, "third");

        runner1.start();
        runner2.start();
        runner3.start();

        while (cdl.getCount() > 0) {
            if (cdl.getCount() == 1) {
                countingStart();
                cdl.countDown();
            }
        }
    }

    public static void countingStart() throws InterruptedException {
        System.out.println("На старт");
        Thread.sleep(500);
        System.out.println("Внимание");
        Thread.sleep(500);
        System.out.println("Марш");
    }
}

class Runner extends Thread {
    private String name;
    CountDownLatch cdl;

    public Runner(CountDownLatch cdl, String name) {
        this.cdl = cdl;
        this.name = name;
    }

    @Override
    public void run() {
        movementToTheStartLine();
        try {
            cdl.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        movementToTheFinish();
    }

    private void movementToTheStartLine() {
        try {
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(name + " on start");
            cdl.countDown();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void movementToTheFinish() {
        try {
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(name + " on finish");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
