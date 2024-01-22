package JavaDevKit.hw_server.server.ui.widgets;


import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ServerLogPanel extends JPanel {

    // массив для логов
    private final List<String> logMessages;


    // виджеты
    private final JTextArea logTextArea;
    private final JScrollPane scrollPane;



    public ServerLogPanel() {
        this.logMessages = new ArrayList<>();

        setLayout(new BorderLayout(2, 1));

        // Создаем JTextArea для отображения логов, ставим запрет на редактирование
        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        logTextArea.setLineWrap(true);  // включить автоматический перенос строки
        logTextArea.setWrapStyleWord(true);  // включить автоматический перенос слов

        // Добавляем текстовое поле в панель для скроллинга
        scrollPane = new JScrollPane(logTextArea);


        //добавляем виджеты
        add((new JLabel("Server log: ", JLabel.CENTER)), BorderLayout.NORTH); // Название окна логов
        add(scrollPane, BorderLayout.CENTER);


        setVisible(false);
    }


    /**
     * Метод для добавления текста в log файл
     *
     * @param text текст логов
     */
    public void serverLogUpdate(String text) {
        JScrollBar verticalScrollBar;verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setValue(scrollPane.getVerticalScrollBar().getMaximum());
        this.logMessages.add(text);
        logTextArea.setText(text);

        repaint();
    }
}
