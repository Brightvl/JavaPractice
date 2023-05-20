package lesson_6.goods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LaptopSet {

    public static Set<Laptop> laptopSet = new HashSet<>();

    public static void fillLaptopSet() {
        String path = "src/main/java/lesson_6/goods/laptops_1.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                String brand = data[0];
                String model = data[1];
                String price = data[2];
                String releaseYear = data[3];
                String operatingSystem = data[10];

                Laptop laptop = new Laptop(brand, model, price, releaseYear, operatingSystem);
                laptop.setOperatingSystem(operatingSystem);

                laptopSet.add(laptop);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
