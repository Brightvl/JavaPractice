package JavaDevKit.hw_server.client.ui.widgets;



import JavaDevKit.hw_server.client.ui.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Панель отображения сообщения чата
 */
public class MessageDisplayWindowPanel extends JPanel {

    private final JTextArea textArea;
    private ClientGUI clientGUI;

    JScrollPane scrollPane;

    /**
     * Конструктор
     */
    public MessageDisplayWindowPanel(ClientGUI clientGUI) {
        this.clientGUI = clientGUI;
        // компоновщик
        setLayout(new BorderLayout(2, 1));

        // для отображения исходящих сообщений
        textArea = new JTextArea("\n\n");
        textArea.setEditable(false); // запрет редактирования
        textArea.setLineWrap(true);  // включить автоматический перенос строки
        textArea.setWrapStyleWord(true);  // включить автоматический перенос слов

        // Добавляем текстовое поле в панель для скроллинга
        this.scrollPane = new JScrollPane(textArea);


        // Добавляем виджеты
        add((new JLabel("General chat", JLabel.CENTER)), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        sendMessage();
    }


    /**
     * Метод для вывода сообщения в поле отправленные сообщения

     */
    public void sendMessage() {
        String tempMessage = clientGUI.getMessage().trim();

        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setValue(verticalScrollBar.getMaximum());
        scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());

        if (!tempMessage.isEmpty()) {
            textArea.setText(tempMessage + "\n");
            repaint();
        }

    }

    /**
     * Метод для вывода сообщения в поле отправленные сообщения
     * @param message отправленное сообщение
     */
    public void sendMessage(String message) {
        String tempMessage = message.trim();
        if (!tempMessage.isEmpty()) {
            textArea.setText(tempMessage + "\n");
            repaint();
        }
    }
}
