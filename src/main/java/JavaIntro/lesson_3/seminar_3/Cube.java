package JavaIntro.lesson_3.seminar_3;

public class Cube {
    public float length;
    public String color;
    public String material;


    public Cube(float length, String color, String material){
        this.length = length;
        this.color = color;
        this.material =material;
    }

    public float getVolume(){
        return length * length * length;
    }
}