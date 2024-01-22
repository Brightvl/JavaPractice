package JavaDevKit.lesson_5.hw5_philosopher;

import static JavaDevKit.lesson_5.hw5_philosopher.ui.Colorize.stringColor;

public class Table {
    private Fork fork1 = new Fork(stringColor(31, "1"));
    private Fork fork2 = new Fork(stringColor(32, "2"));
    private Fork fork3 = new Fork(stringColor(33, "3"));
    private Fork fork4 = new Fork(stringColor(34, "4"));
    private Fork fork5 = new Fork(stringColor(35, "5"));


    private Philosopher philosopher1 = new Philosopher(stringColor(31, "№1"), 3, fork1, fork2);
    private Philosopher philosopher2 = new Philosopher(stringColor(32, "№2"), 3, fork2, fork3);
    private Philosopher philosopher3 = new Philosopher(stringColor(33, "№3"), 3, fork3, fork4);
    private Philosopher philosopher4 = new Philosopher(stringColor(34, "№4"), 3, fork4, fork5);
    private Philosopher philosopher5 = new Philosopher(stringColor(35, "№5"), 3, fork5, fork1);


    public void startEating() {
        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();


    }
}
