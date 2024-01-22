package JavaDevKit.hw_server.file_manager;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Manager implements FileManager {


    private File fileName;
    public Manager(File fileName) {
        this.fileName = fileName;
    }

    /**
     * Создает форматированное время
     *
     * @return время в формате dd/MM/yy HH:mm
     */
    private String getDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Задаем формат даты и времени
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        // Форматируем текущую дату и время
        return '['+currentDateTime.format(formatter)+']';
    }

    /**
     * Загружает из файла
     * @return строку с текстом
     */
    @Override
    public String  load() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e) {
            save("Run server GUI"); // рекурсивно создаю файл
            return load();
        }

    }

    /**
     * Сохраняет в файл
     * @param text текст
     */
    @Override
    public void save(String text) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(getDateTime() + " " + text);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
