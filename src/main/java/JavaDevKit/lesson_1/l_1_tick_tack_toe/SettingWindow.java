package JavaDevKit.lesson_1.l_1_tick_tack_toe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    //region поля
    // текст в меню настроек
    public static final String BTN_START = "Start new game";
    public static final String LABEL_CHOICE_MODE = "Выберите режим игры";
    public static final String BTN_HUMAN_VERSUS_AI = "Человек против компьютера";
    public static final String BTN_HUMAN_VERSUS_HUMAN = "Человек против человека";
    public static final String SIZE_PREFIX = "Установленный размер поля: ";
    public static final String WIN_LENGTH_PREFIX = "Установленная длина: ";
    public static final String LABEL_CHOICE_SIZE = "Выберите размеры поля";
    public static final String LABEL_CHOICE_WIN_LENGTH = "Выберите длину для победы";

    // режимы игры
    public static final int MODE_HUM_VS_AI = 0;
    public static final int MODE_HUM_VS_HUM = 1;

    // размер игрового поля
    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 10;

    // размер поля настроек
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;

    GameWindow gameWindow; // вынесли для удобства работы объект передается в конструктор

    // виджеты
    JRadioButton humanVSHuman, humanVSAi; // переключатель режима игры
    Label labelCurSize, labelWinLength; // ярлык с информацией
    JSlider sizeSlider, winSlider; // скроллинг для изменения игровых параметров
    JButton btnStartNewGame; // кнопка новой игры

    //endregion

    //region  Конструкторы
    SettingWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow; // сохраняем на полях
        //region параметры окна
        // координаты игрового окна
        int centerGameWindowX = gameWindow.getX() + gameWindow.getWidth() / 2;
        int centerGameWindowY = gameWindow.getY() + gameWindow.getHeight() / 2;

        // Установка положения окна настроек, относительно центра игрового окна и где оно изначально появилось
        setLocation(centerGameWindowX - WIDTH / 2, centerGameWindowY - HEIGHT / 2);
        // размер окна
        setSize(WIDTH, HEIGHT);
        //endregion
        add(createMainPanel()); // главная панель
        add(createButtonStart(), BorderLayout.SOUTH); // кнопка новой игры
    }
    //endregion

    //region панель настроек

    /**
     * Создание главного меню настроек
     *
     * @return компонент панель
     * (Компонент — это объект, имеющий графическое представление, которое может отображаться на экране и
     * взаимодействовать с пользователем.)
     */
    private Component createMainPanel() {
        // общая панель с настройками игры
        JPanel panel = new JPanel(new GridLayout(3, 1));

        panel.add(createChoiceModePanel()); // режим игры
        panel.add(createChoiceSizePanel()); // размер поля
        panel.add(createChoiceWinLengthPanel()); // значение для победы
        return panel;
    }


    /**
     * Метод создает панель с выбором режима игры
     * @return компонент панель
     */
    private Component createChoiceModePanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));

        // Ярлык панели
        Label title = new Label(LABEL_CHOICE_MODE);

        // создали кнопки
        humanVSAi = new JRadioButton(BTN_HUMAN_VERSUS_AI);
        humanVSHuman = new JRadioButton(BTN_HUMAN_VERSUS_HUMAN);
        // сгруппировали кнопки
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(humanVSAi);
        buttonGroup.add(humanVSHuman);
        // включили кнопку
        humanVSAi.setSelected(true);

        // добавляем на основную панель
        panel.add(title);
        panel.add(humanVSAi);
        panel.add(humanVSHuman);

        return panel;
    }
    /**
     * Метод создает панель с выбором размера игрового поля
     * @return компонент панель
     */
    private Component createChoiceSizePanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        // Ярлык для панели
        Label title = new Label(LABEL_CHOICE_SIZE);


        labelCurSize = new Label(SIZE_PREFIX + MIN_SIZE);
        sizeSlider = new JSlider(MIN_SIZE, MAX_SIZE, MIN_SIZE); // положение скроллера
        sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int curSize = sizeSlider.getValue();
                labelCurSize.setText(SIZE_PREFIX + curSize);
                winSlider.setMaximum(curSize);
            }
        });

        panel.add(title,BorderLayout.NORTH);
        panel.add(labelCurSize,BorderLayout.NORTH);
        panel.add(sizeSlider);
        return panel;
    }

    /**
     * Метод создает панель с выбором размера игрового поля
     * @return компонент панель
     */
    private Component createChoiceWinLengthPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        Label title = new Label(LABEL_CHOICE_WIN_LENGTH);

        labelWinLength = new Label(WIN_LENGTH_PREFIX + MIN_SIZE);
        winSlider = new JSlider(MIN_SIZE, MAX_SIZE, MIN_SIZE);
        winSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelWinLength.setText(SIZE_PREFIX + winSlider.getValue());
            }
        });

        panel.add(title);
        panel.add(labelWinLength);
        panel.add(winSlider);
        return panel;
    }
    //endregion

    //region кнопка новой игры

    /**
     * Создание кнопки новой игры
     *
     * @return компонент кнопка
     */
    private Component createButtonStart() {
        btnStartNewGame = new JButton(BTN_START); // название кнопки

        // когда кнопка будет нажата меню скроется, начнется игра
        btnStartNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                startGame();
            }
        });
        return btnStartNewGame;
    }

    /**
     * Метод устанавливает необходимые параметры и начинает игру
     */
    private void startGame() {
        int mode;
        // .isSelected() - возвращает состояние кнопки. True, если кнопка переключения выбрана, и false, если нет.
        if (humanVSAi.isSelected()) {
            mode = MODE_HUM_VS_AI;
        } else if (humanVSHuman.isSelected()) {
            mode = MODE_HUM_VS_HUM;
        } else {
            throw new RuntimeException("Unknown game mode");
        }
        int size = sizeSlider.getValue();
        int winLength = winSlider.getValue();

        gameWindow.startNewGame(mode, size, size, winLength);
    }
    //endregion

}
