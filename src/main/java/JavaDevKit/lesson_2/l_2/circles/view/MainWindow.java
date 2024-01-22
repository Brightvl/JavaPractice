package JavaDevKit.lesson_2.l_2.circles.view;



import JavaDevKit.lesson_2.l_2.circles.exceptions.BallsOverflowException;
import JavaDevKit.lesson_2.l_2.circles.sprites.Background;
import JavaDevKit.lesson_2.l_2.circles.sprites.Ball;
import JavaDevKit.lesson_2.l_2.common.CanvasRepaintListener;
import JavaDevKit.lesson_2.l_2.common.Interactable;
import JavaDevKit.lesson_2.l_2.common.MainCanvas;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainWindow extends JFrame implements CanvasRepaintListener, Thread.UncaughtExceptionHandler {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String TITLE = "Circles";
    private static final int DEFAULT_COUNT_SPRITES = 10;
    private static final int MAX_COUNT_SPRITES = 15;
    private static final Random random = new Random();

    private Interactable[] sprites;
    private int countSprites;

    public MainWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle(TITLE);

        initSprites();
        MainCanvas canvas = new MainCanvas(this);
        add(canvas);

        addMouseListener(new MouseListener(this));

        setVisible(true);
    }

    private void initSprites() {
        sprites = new Interactable[MAX_COUNT_SPRITES];
        sprites[0] = new Background();
        countSprites = 1;
        for (int i = 1; i < DEFAULT_COUNT_SPRITES; i++) {
            addSprite(random.nextInt(WIDTH), random.nextInt(HEIGHT));
        }
    }

    public void addSprite(int x, int y) {
        if (countSprites >= MAX_COUNT_SPRITES) {
            throw new BallsOverflowException();
        }
        sprites[countSprites++] = new Ball(x, y);
    }

    public void removeSprite() {
        if (countSprites <= 1) {
            return;
        }
        countSprites--;
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < countSprites; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < countSprites; i++) {
            sprites[i].render(canvas, g);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof BallsOverflowException) {
            e.fillInStackTrace();
        }
    }
}
