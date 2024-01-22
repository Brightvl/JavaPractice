package JavaDevKit.lesson_2.l_2.circles.view;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
    private MainWindow mainWindow;

    public MouseListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){
            mainWindow.removeSprite();
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            mainWindow.addSprite(e.getX(), e.getY());
        }
    }
}
