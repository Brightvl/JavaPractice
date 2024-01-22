package JavaDevKit.lesson_1.l_1_tick_tack_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    // размеры окна
    private static final int WIDTH = 555;
    private static final int HEIGHT = 507;

    // виджеты
    JButton btnStart, btnExit;
    SettingWindow settingWindow;
    Map map;


    GameWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null); // по центру экрана

        setTitle("TicTacToe"); // название окна
        setResizable(false); // чтобы не менялось

        // создание кнопок
        btnStart = new JButton("New Game");
        btnExit = new JButton("Exit");
        // окно настроек
        settingWindow = new SettingWindow(this);
        // игровое окно
        map = new Map();

        // слушатель кнопки выход (анонимный класс)
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // слушатель кнопки старт игры (анонимный класс)
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // выводит доп окно настроек todo надо сделать в общем окне
                //  add(settingWindow);
                settingWindow.setVisible(true);
            }
        });

        //добавление виджетов
        add(map); // добавляем игровое окно на панель (белое пространство)

        // создаем панель для кнопок 1 строка 2 колонки (порядок важен)
        JPanel panelBottom = new JPanel(new GridLayout(1, 2));
        // добавляем кнопки на панель
        panelBottom.add(btnStart);
        panelBottom.add(btnExit);
        add(panelBottom, BorderLayout.SOUTH); // добавляем панель на игровое в GameWindow снизу

        // Отображаем панель
        setVisible(true);
    }

    /**
     * Метод для запуска игры
     * @param mode режим игры
     * @param sizeX размер поля по x
     * @param sizeY размер поля по y
     * @param winLen длина для победы
     */
    void startNewGame(int mode, int sizeX, int sizeY, int winLen){
        map.startNewGame(mode, sizeX, sizeY, winLen);
    }
}
