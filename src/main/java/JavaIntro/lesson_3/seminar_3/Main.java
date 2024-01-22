package JavaIntro.lesson_3.seminar_3;

import java.util.*;

public class Main {

    /**
     * 1. Даны сведения об экспортируемых товарах:
     * указывается наименование товара,
     * страна, экспортирующая товар,
     * и объем поставляемой партии в штуках.
     * Найти страны, которые экспортируют данный(введенный с кл-ы) товар,
     * и общий объем его экспорта.
     */
    public static void main(String[] args) {
        List<Student> studentList = GetStudents();
        for (Student a : studentList) {
            if (a.name.endsWith("on")) {
                int sum = 0;
                for (Integer ball : a.balls) {
                    sum += ball;
                }
                if (sum % 2 == 0) {
                    System.out.println(a.salary);
                }
            }
        }
        System.out.println("Уникальный список: " + unicList(studentList));
    }

    private static Collection unicList(List<Student> studentList) {
        return new HashSet(studentList);
    }

    public static List<Student> GetStudents() {

        List<Student> students = new ArrayList<Student>();
        students.add(new Student("name1on", 1111, 1000, Arrays.asList(1, 2, 3)));
        students.add(new Student("name2", 2222, 1200, Arrays.asList(2, 4, 3)));
        students.add(new Student("name2", 2222, 1200, Arrays.asList(2, 4, 3)));
        students.add(new Student("name2", 2222, 1200, Arrays.asList(2, 4, 3)));
        students.add(new Student("name2", 2222, 1200, Arrays.asList(2, 4, 3)));
//        students.add(new Student("name3on", 3333, 1300, Arrays.asList(1,3,3)));
//        students.add(new Student("name4", 4444, 1400, Arrays.asList(1,2,5)));
//        students.add(new Student("name5", 2222, 1500, Arrays.asList(2,2,2)));
//        students.add(new Student("name6", 3333, 1100, Arrays.asList(1,4,3)));
//        students.add(new Student("name7on", 5555, 1200, Arrays.asList(6,2,5)));
        return students;
    }
}