package JavaDevKit.lesson_5.hw5_philosopher;

public class Philosopher extends Thread {
    private Spaghetti cdl;
    private volatile Fork left;
    private volatile Fork right;

    public Philosopher(String name, int count, Fork left, Fork right) {
        super(name);
        this.cdl = new Spaghetti(count);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        System.out.printf("%s философ сел за стол...\n", getName());
        try {
            while (cdl.getCount() > 0) {
                // Взятие вилок сначала левая потом правая
                synchronized (left) {
                    while (left.getBusy()) { // если занята вилка
                        left.wait();
                        //переводим поток в режим ожидания, разблокируя блок, по сути ждем пока другой
                        // поток вызовет метод notify, тем самым разрешая нам работать с мьютексом
                    }
                    left.setBusy(true); // либо просто вилка свободна, занимаем

                    synchronized (right) {
                        while (right.getBusy()) { // если правая вилка занята
                            left.setBusy(false); // освобождаем левую вилку для других
                            left.notify(); // сообщаем другим потокам, что можно стартовать
                            right.wait(); // а сами падаем в спячку
                        }
                        right.setBusy(true); // а если все ок хватаем 2 вилки и кушаем
                        Thread.sleep(500);
                        eat();
                        Thread.sleep(500);
                    }
                    // Освобождение вилок, в обратном порядке, чтобы справа сидящий философ смог уже начать работать
                    // с ней
                    right.setBusy(false);
                    left.notify();
                    left.setBusy(false);
                }
                think();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Философ ест
     */
    private void eat() {
        System.out.printf("%s начал кушать... в левой руке %s, в правой %s\n",
                getName(),
                left.getName(),
                right.getName());
        cdl.countDown();
    }

    /**
     * Философ думает
     *
     * @throws InterruptedException проверка на прерывание
     */
    private void think() throws InterruptedException {
        if (cdl.getCount() > 0) {
            System.out.printf("%s задумался... положил вилки слева %s, справа %s\n",
                    getName(),
                    left.getName(),
                    right.getName());
        } else {
            System.out.printf("%s закончил есть... положил вилки, слева %s, справа %s и задумался...\n",
                    getName(),
                    left.getName(),
                    right.getName());
        }
    }
}



