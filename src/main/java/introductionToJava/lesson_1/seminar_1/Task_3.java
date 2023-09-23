package introductionToJava.lesson_1.seminar_1;

// Дана строка. Поменять местами ее половины.
public class Task_3 {
    public static void main(String[] args) {
        System.out.println(replacePartOfString("Hi bro "));

    }
    public static String replacePartOfString(String str){
        int length = str.length();
        String sub1 = str.substring(0, length / 2);
        String sub2 = str.substring(length / 2, length);

        return sub2 + sub1;
    }

}
