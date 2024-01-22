package JavaIntro.lesson_2.old_group;

import java.util.Scanner;

public class S_2 {

    public static Scanner IScaner = new Scanner(System.in);

    /*1. Дано целое число N (>0) и символы c1 и c2.
    Написать метод, который вернет строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с c1.
    N=5
    c1=”Oleg”
    c2=”Vasya”
    res = “OlegVasyaOlegVasyaOleg”*/




    /*2. Напишите метод, который сжимает строку.
    Пример: вход aaaabbbcddad.
    Выход abcd
    charAt(i) и indefOf(s) => не найден -1*/

    public static void main(String[] args) {
        // Integer N = iScanner.nextInt();
        // System.out.println(sumString(N));
        String defaultt = "aaaabbbcddad";
        // res = ""; s = 'a'
        // -1 -> res = 'a'
        // s = 'a' -> 0 -> res = 'a'
        // s = 'a' -> 0 -> res = 'a'
        // s = 'b' -> -1 -> res = 'ab'
        // s = 'b' -> 1 -> res = 'ab'
        String res = "";
        for (int i = 0; i < defaultt.length(); i++) {
            char s = defaultt.charAt(i);
            if (res.indexOf(s) == -1) res+=s;
        }
        System.out.println(res);

    }

    public static String sumString(Integer N) {
        String c1 = "Oleg";
        String c2 = "Kamila";
        String res = "";
        for (int i=0; i<N; i++) {
            /* if (i % 2 == 0) res+=c1;
            else res+=c2; */
            res+= i % 2 == 0 ? c1:  c2;// i++ ++i
        }
        return res;
    }

/*Напишите метод, который принимает на вход строку (StringBulder) и определяет является ли строка палиндромом (возвращает boolean значение).
equals и StringBulder для revers*/

    /*Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод, который запишет эту строку в простой текстовый файл, обработайте исключения.*/

}
