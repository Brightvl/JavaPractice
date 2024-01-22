package JavaDevKit.lesson_2.l_2.common;



import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {
    private final CanvasRepaintListener controller;
    private long lastFrameTime;

    public MainCanvas(CanvasRepaintListener controller){
        this.controller = controller;
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        onDraw(g);
        sleep(16);
        repaint();
    }

    private void onDraw(Graphics g) {
        long curFrameTime = System.nanoTime();
        float deltaTime = (curFrameTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = curFrameTime;
        controller.onDrawFrame(this, g, deltaTime);
    }

    private void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public int getLeft(){
        return 0;
    }

    public int getRight(){
        return getWidth() - 1;
    }

    public int getTop(){
        return 0;
    }

    public int getBottom(){
        return getHeight() - 1;
    }
}
