package JavaIntro.lesson_3.seminar_3;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Cube> cubes = getCubes();
        int amountYellow = 0;
        float volumeYellow = 0;
        int amountWood = 0;

        for (Cube cube : cubes) {
            if (cube.color.equals("yellow")) {
                amountYellow += 1;
                volumeYellow += cube.getVolume();
            }
            if (cube.material.equals("wood")) {
                amountWood += 1;
            }
        }

        System.out.println(amountYellow);
        System.out.println(volumeYellow);
        System.out.println(amountWood);
    }

    public static ArrayList<Cube> getCubes() {
        ArrayList<Cube> cubes = new ArrayList<Cube>();
        cubes.add(new Cube(2, "red", "wood"));
        cubes.add(new Cube(3, "yellow", "paper"));
        cubes.add(new Cube(7, "yellow", "wood"));
        cubes.add(new Cube(3, "green", "steel"));
        cubes.add(new Cube(1, "yellow", "steel"));
        return cubes;
    }
}
