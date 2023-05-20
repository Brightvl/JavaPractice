package lesson_6.goods;

import java.util.HashSet;
import java.util.Set;

public class LaptopSet {
    public static Set<Laptop> laptopSet = new HashSet<>() {
        {
            add(new Laptop("ASUS", 2021, 15.6,"Windows"));
            add(new Laptop("ASUS VivoBook", 2021, 14,"Unknown"));

        }
    };
}
