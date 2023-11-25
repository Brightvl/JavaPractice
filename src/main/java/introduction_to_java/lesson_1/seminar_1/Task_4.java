package introduction_to_java.lesson_1.seminar_1;

// Given two binary strings a and b, return their sum as a binary string.
public class Task_4 {
    public static String addBinary(String a, String b) {
        int mem = 0;
        String result = "";

        while (a.length() > b.length()) {
            b = "0" + b;
        }

        while (b.length() > a.length()) {
            a = "0" + a;
        }


        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                result += (0 + mem);
                mem = 0;
            } else if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                if (mem == 1) result += 1;
                else {
                    result += 0;
                    mem = 1;
                }
            } else {
                if (mem == 1) {
                    result += 0;
                    mem = 1;
                } else result += 1;
            }
        }

        if (mem == 1) result += 1;

        StringBuilder builder = new StringBuilder(result);
        return builder.reverse().toString();
    }
}
