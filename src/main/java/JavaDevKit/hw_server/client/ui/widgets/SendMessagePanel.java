package JavaDevKit.hw_server.client.ui.widgets;




import JavaDevKit.hw_server.client.ui.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Панель для ввода и отправки сообщений
 */
public class SendMessagePanel extends JPanel {

    // JTextField для однострочного ввода сообщения(чтобы не было бага с размером окна)
    private JTextField textInputPanel;

    //mainFrame
    private final ClientGUI clientGUI;


    /**
     * Конструктор
     * @param clientGUI главное окно клиента
     */
    public SendMessagePanel(ClientGUI clientGUI) {
        this.clientGUI = clientGUI;

        setLayout(new BorderLayout(1, 2));
        add(createTextInputArea());
        add(createSendMessageButton(), BorderLayout.EAST);
    }

    /**
     * Создает панель ввода данных, обрабатывая нажатия клавиатуры
     * @return компонент текстовое поле
     */
    private Component createTextInputArea() {
        this.textInputPanel = new JTextField();
        this.textInputPanel.setEditable(true);

        // Добавляем KeyListener к textInputPanel для обработки нажатия клавиши Enter
        this.textInputPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });
        return textInputPanel;
    }

    /**
     * Создание кнопки отправки сообщения обрабатывая нажатия мыши
     * @return
     */
    private Component createSendMessageButton() {
        //Widgets
        JButton sendMessageButton = new JButton("Send");

        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        return sendMessageButton;
    }


    /**
     * Метод для отправки сообщения
     */
    private void sendMessage() {
        // получаем текст с поля ввода сообщения
        String sendMessage = textInputPanel.getText();
        // Очищаем текстовое поле
        this.textInputPanel.setText("");
        if (!sendMessage.isEmpty()) {
            this.clientGUI.appendMessage(sendMessage.trim());
        }
    }
}
