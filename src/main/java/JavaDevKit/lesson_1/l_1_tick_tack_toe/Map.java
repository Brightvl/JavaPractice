package JavaDevKit.lesson_1.l_1_tick_tack_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    // для AI
    private static final Random RANDOM = new Random();
    // виды ходов
    private static final int HUMAN_DOT = 1;
    private static final int AI_DOT = 2;
    private static final int EMPTY_DOT = 0;

    // todo заполнение?
    private static final int PADDING = 10;

    // состояние игры
    private int gameStateType;
    private static final int STATE_GAME = 0; // идет игра
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;
    private static final int STATE_DRAW = 3;

    // msg
    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    private static final String MSG_WIN_AI = "Победил компьютер!";
    private static final String MSG_DRAW = "Ничья!";

    // параметры окна
    private int width, height, cellWidth, cellHeight;
    // для запуска
    private int mode, fieldSizeX, fieldSizeY, winLen;
    // игровое поле
    private int[][] field;
    // флаг состояния запущенности игры
    private boolean gameWork;

    Map() {
        // задний фон
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (gameWork) {
                    update(e); // если true идет отрисовка игрового поля
                }
            }
        });
    }

    /**
     * Инициализация игрового поля под капотом
     */
    private void initMap() {
        field = new int[fieldSizeY][fieldSizeX];
    }

    /**
     * Для отрисовки игрового окна, по сути запуска игры
     *
     * @param mode   режим игры
     * @param sizeX  размер игрового поля по х
     * @param sizeY  размер игрового поля по у
     * @param winLen ходов для победы
     */
    void startNewGame(int mode, int sizeX, int sizeY, int winLen) {
        this.mode = mode;
        this.fieldSizeX = sizeX;
        this.fieldSizeY = sizeY;
        this.winLen = winLen;

        // Создает массив под капотом
        initMap();
        // Запуск игры
        gameWork = true;
        // состояние игры - в игре
        gameStateType = STATE_GAME;

        // перекрашивание
        repaint();
    }

    /**
     * Метод проверяет и управляет процессом игры при каждом нажатии мыши
     * работа идет на уровне массива field[][]
     *
     * @param mouseEvent нажатие мыши
     */
    private void update(MouseEvent mouseEvent) {
        // получаем параметры в каком месте была нажата мышь и делим на ширину ячейки
        int x = mouseEvent.getX() / cellWidth;
        int y = mouseEvent.getY() / cellHeight;

        // проверка хода, если клетка за пределами поля или занята другим знаком, ничего не рисуем
        if (!isValidCell(x, y) || !isEmptyCell(x, y)) {
            return;
        }
        field[y][x] = HUMAN_DOT;//записываем ход человека
        // проверка на завершение игры
        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) {
            return;
        }
        aiTurn(); // ход AI
        repaint();// перекрашивание чтобы отобразился ход ai
        checkEndGame(AI_DOT, STATE_WIN_AI); // проверка на завершение игры
    }

    /**
     * Проверка сделанного хода в пределах поля
     *
     * @param x координата x
     * @param y координата y
     * @return true если в пределах
     */
    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Проверка на занятость клетки
     *
     * @param x координата x
     * @param y координата y
     * @return true если клетка свободна
     */
    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    /**
     * Ход ai (простой рандомный)
     */
    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }

    /**
     * Проверка заполнена ли карта, в неком роде на ничью
     *
     * @return true если заполнена
     */
    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Проверка закончилась ли игра
     *
     * @param dot          знак игрока
     * @param gameOverType состояние игры, идет игра, победа игрока, победа ai, все клетки заполнены/ничья
     * @return false если состояние не поменялось
     */
    private boolean checkEndGame(int dot, int gameOverType) {
        if (checkWin(dot)) {
            this.gameStateType = gameOverType; // меняем игровое состояние
            repaint();
            return true;
        } else if (isMapFull()) {
            this.gameStateType = STATE_DRAW;
            repaint();
            return true;
        }
        return false;
    }

    /**
     * Проверка на победу игрока
     *
     * @param dot тип хода игрока
     * @return true если победа
     */
    private boolean checkWin(int dot) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLen, dot)) return true;
                if (checkLine(i, j, 1, 1, winLen, dot)) return true;
                if (checkLine(i, j, 0, 1, winLen, dot)) return true;
                if (checkLine(i, j, 1, -1, winLen, dot)) return true;
            }
        }
        return false;
    }

    /**
     * проверяет определенную линию (горизонтальную, вертикальную, диагональную) на наличие выигрышной комбинации.
     *
     * @param x   координата начальной клетки x
     * @param y   координата начальной клетки y
     * @param vx  направление проверки по x
     * @param vy  направление проверки по y
     * @param len длина проверяемой линии
     * @param dot тип хода
     * @return
     */
    private boolean checkLine(int x, int y, int vx, int vy, int len, int dot) {
        // вычисляются координаты конечной клетки, и если эта клетка находится за пределами поля, возвращается false
        int far_x = x + (len - 1) * vx;
        int far_y = y + (len - 1) * vy;
        // параллельно идет проверка чтобы не выйти за границы массива
        if (!isValidCell(far_x, far_y)) {
            return false;
        }
        // проверяется каждая клетка в линии: если хотя бы одна клетка не соответствует типу хода (dot), то
        // возвращается false.
        for (int i = 0; i < len; i++) {
            if (field[y + i * vy][x + i * vx] != dot) {
                return false;
            }
        }
        return true;
    }

    /**
     * Является стандартным методом из класса JComponent и вызывается автоматически при необходимости перерисовки компонента.
     * В данном случае, перед тем как выполнить свою работу, метод вызывает super.paintComponent(g) для выполнения стандартной отрисовки компонента.
     * Затем проверяется условие if (gameWork). Если переменная gameWork равна true, то вызывается метод render(g) для отрисовки пользовательского контента игры
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameWork) {
            render(g);
        }
    }

    /**
     * Отвечает за фактическую отрисовку пользовательского контента.
     */
    private void render(Graphics g) {
        //размеры
        width = getWidth();
        height = getHeight();
        //размеры клеток для хода
        cellWidth = width / fieldSizeX;
        cellHeight = height / fieldSizeY;

        // рисуем клетки на поле
        renderCell(g, width, height, cellWidth, cellHeight);
        // рисуем ходы игроков
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                // если клетка пуста пропускаем
                if (field[y][x] == EMPTY_DOT) {
                    continue;
                }
                // если ход человека рисуем крест
                if (field[y][x] == HUMAN_DOT) {
                    g.drawLine(x * cellWidth + PADDING, y * cellHeight + PADDING,
                            (x + 1) * cellWidth - PADDING, (y + 1) * cellHeight - PADDING);
                    g.drawLine(x * cellWidth + PADDING, (y + 1) * cellHeight - PADDING,
                            (x + 1) * cellWidth - PADDING, y * cellHeight + PADDING);
                }
                // если ai, то круг
                else if (field[y][x] == AI_DOT) {
                    g.drawOval(x * cellWidth + PADDING, y * cellHeight + PADDING,
                            cellWidth - PADDING * 2, cellHeight - PADDING * 2);
                } else {
                    throw new RuntimeException("unchecked value " + field[y][x] +
                            " in cell: x=" + x + " y=" + y);
                }
            }
        }
        // если состояние игры изменилось выводим сообщение
        if (gameStateType != STATE_GAME) {
            showMessage(g);
        }
    }

    /**
     * Рендерим клетки на поле
     *
     * @param graphics   отвечает за фактическую отрисовку пользовательского контента.
     * @param width      ширина игрового окна
     * @param height     высота игрового окна
     * @param cellWidth  ширина клетки
     * @param cellHeight высота клетки
     */
    private void renderCell(Graphics graphics, int width, int height, int cellWidth, int cellHeight) {
        //цвет границы клетки
        graphics.setColor(Color.BLACK);
        //линия по y от нулевой высоты (верхняя граница) до нижнего размера окна
        for (int h = 0; h < fieldSizeX; h++) {
            int y = h * cellHeight;
            graphics.drawLine(0, y, width, y); // координаты 1-й точки и 2-й
        }
        //линия по x от нулевой ширины (левая граница) до правой границы ширины окна
        for (int w = 0; w < fieldSizeX; w++) {
            int x = w * cellWidth;
            graphics.drawLine(x, 0, x, height);
        }
    }


    /**
     * Вывод игрового состояния игры на экран, всегда переводит состояние игры в false
     * @param g отвечает за фактическую отрисовку пользовательского контента.
     */
    private void showMessage(Graphics g) {
        // фон текста
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, getHeight() / 2, getWidth(), 70);
        // сам текст
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        // непосредственно сообщение
        switch (gameStateType) {
            case STATE_DRAW -> g.drawString(MSG_DRAW, 180, getHeight() / 2 + 60);
            case STATE_WIN_HUMAN -> g.drawString(MSG_WIN_HUMAN, 20, getHeight() / 2 + 60);
            case STATE_WIN_AI -> g.drawString(MSG_WIN_AI, 70, getHeight() / 2 + 60);
            default -> throw new RuntimeException("Unchecked gameOverState: " + gameStateType);
        }
        // если вызван класс по сути игра окончена
        gameWork = false;
    }
}
