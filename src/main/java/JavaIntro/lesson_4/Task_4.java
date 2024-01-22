package JavaIntro.lesson_4;

import java.util.Arrays;
import java.util.Stack;

public class Task_4 {
    public static void main(String[] args) {
        //System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
//System.out.println(simplifyPath("/home//foo/"));

    }

    public static String simplifyPath(String path) {
        String[] arrayStr = path.split("/");
        System.out.println(Arrays.toString(arrayStr));

        Stack<String> result = new Stack<>();
        for (int i = 0; i < arrayStr.length; i++) {
            if (arrayStr[i].equals("..")) {
                if (!result.isEmpty()) {
                    result.pop();
                }
            } else if ((!arrayStr[i].isEmpty()) && (!arrayStr[i].equals("."))) {
                result.add(arrayStr[i]);
            }
        }
        System.out.println(result + "аааа");
        System.out.println();

        String resStr = "/";
        for (int i = 0; i < result.size(); i++) {
            resStr += result.get(i) + "/";
            System.out.println(resStr + "-----");

        }
        if (resStr.length() > 1) {
            return resStr.substring(0, resStr.length() - 1);
        }
        return resStr;
    }
}