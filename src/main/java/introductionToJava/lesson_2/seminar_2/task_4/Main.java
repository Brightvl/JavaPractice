package introductionToJava.lesson_2.seminar_2.task_4;

public class Main {
    public static void main(String[] args) {
        Vector vector = new Vector(1.0,2.0,3.0);
        System.out.println(vector);
        System.out.println("vector.vectorLength() = " + vector.vectorLength());
        vector.Multiplication(new Vector(1.2,3.0,2.1));
        System.out.println("vector.vectorPr() = " + vector.vectorPr(new Vector(1.0, 2.0, 3.0)));
    }
}
