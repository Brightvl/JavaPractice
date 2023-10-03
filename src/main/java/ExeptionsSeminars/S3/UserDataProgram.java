package ExeptionsSeminars.S3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class UserDataProgram {

    /**
     * Точка входа. Запрашиваем параметры. Проверяем количество введенных параметров, дату рождения, пол, если все
     * верно создаем объект UserData и записываем его в файл относительно фамилии.
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные разделенные пробелом:" +
                    "\n<Фамилия> <Имя> <Отчество> <дата рождения (дд.мм.гггг)> <номер телефона> <пол (м/ж)>");
            String input = scanner.nextLine();
            String[] data = input.split(" ");

            if (data.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных, введите 6 параметров");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            if (!isValidDate(birthDate)) {
                throw new IllegalArgumentException("Проблема с датой рождения, убедитесь в правильности написания");
            }
            if (Character.toLowerCase(gender) != 'м' && Character.toLowerCase(gender) != 'ж') {
                throw new IllegalArgumentException("Неверный формат данных, проверьте указанный вами пол");
            }

            UserData userData = new UserData(lastName, firstName, middleName, birthDate, phoneNumber, gender);
            userData.saveToFile();

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Метод для валидации даты рождения.
     *
     * @param date Строка с датой рождения в формате "dd.mm.yyyy"
     * @return true, если дата валидна, иначе false
     */
    private static boolean isValidDate(String date) {
        try {
            String[] parts = date.split("\\.");
            if (parts.length != 3) {
                return false;
            }
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            return day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1900 && year <= 2023;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

class UserData {
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private long phoneNumber;
    private char gender;

    public UserData(String lastName,
                    String firstName,
                    String middleName,
                    String birthDate,
                    long phoneNumber,
                    char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    /**
     * Метод сохраняет данные пользователя в текстовый файл с именем, совпадающим с фамилией пользователя.
     * Если файл существует, данные добавляются в конец файла.
     */
    public void saveToFile() {
        String userData = String.format("%s %s %s %s %d %c",
                lastName, firstName, middleName, birthDate, phoneNumber, gender);

        String fileName = lastName + ".txt";
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
            printWriter.println(userData);
            System.out.println("Данные успешно добавлены в файл " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении данных в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
