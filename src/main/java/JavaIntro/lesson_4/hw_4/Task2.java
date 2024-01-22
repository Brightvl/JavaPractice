package JavaIntro.lesson_4.hw_4;

import java.util.Stack;

public class Task2 {
    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * An input string is valid if:
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     * "()[]{}"; valid
     * "([)]"; !valid
     * 1) создаем стек для скобок
     * 2) перебираем все символы в строке
     * 3.1) если символ - открывающая скобка, то кладем Plk в стек
     * 3.2) если символ - закрывающая скобка и последняя скобка в стеке - открывающая скобка того же типа, то удаляем
     * Plk из стека
     * 3.3) если символ не является скобкой или не соответствует последней скобке в стеке, то строка невалидна
     * 4) если стек пустой, то строка валидна
     */
    public static void main(String[] args) {
        String s1 = "()[]{}";
        System.out.println(isValid(s1));
    }
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if(c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if(c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if(c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
