package JavaDevKit.lesson_3;

/**
 * Урок 3. Обобщенное программирование
 */
public class HW3 {
    public static void main(String[] args) {
        {//Task_1
            int firstNum = 5;
            double secondNum = 7d;
            System.out.printf("%s + %s = %s\n", firstNum, secondNum, Calculator.sum(firstNum, secondNum));
            System.out.printf("%s - %s = %s\n", firstNum, secondNum, Calculator.subtract(firstNum, secondNum));
            System.out.printf("%s * %s = %s\n", firstNum, secondNum, Calculator.multiply(firstNum, secondNum));
            System.out.printf("%s / %s = %s\n", firstNum, secondNum, Calculator.divide(firstNum, secondNum));
        }

        {//Task_2
            String[] strings = {"a", "2"};
            Integer[] strings1 = {2, 3};
            System.out.println(HWTask2.compareArrays(strings, strings1));
        }

        {//Task_3
            Pair<Calculator, String> pairs = new Pair(new Calculator(), "Строка ");
            System.out.println(pairs.getFirst());
            System.out.println(pairs.getSecond());
            System.out.println(pairs);
        }
    }
}

//region Task_1

/**
 * Task_1
 * <p>
 * - Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(),
 * divide(), subtract(). Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
 */
class Calculator {
    public static <T extends Integer, T2 extends Double> Double sum(T firstNum, T2 secondNum) {

        return firstNum.doubleValue() + secondNum.doubleValue();
    }

    public static <T extends Number, T2 extends Double> Double subtract(T firstNum, T2 secondNum) {
        return firstNum.doubleValue() - secondNum.doubleValue();
    }

    public static <T extends Number, T2 extends Number> Double multiply(T firstNum, T2 secondNum) {
        return firstNum.doubleValue() * secondNum.doubleValue();
    }

    public static <T extends Number> Double divide(T firstNum, T secondNum) {
        return firstNum.doubleValue() / secondNum.doubleValue();
    }
}
//endregion

//region Task_2

/**
 * Task_2
 * <p>
 * - Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые,
 * и false в противном случае. Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа по парно. (используйте instanceof)
 */
class HWTask2 {
    public static <T> boolean compareArrays(T[] firstArray, T[] secondArray) {
        if (firstArray.length != secondArray.length) {
            return false;
        }
        for (int i = 0; i < firstArray.length; i++) {
            if (!firstArray[i].getClass().isInstance(secondArray[i])) {
                return false;
            }
        }
        return true;
    }
}


//endregion

//region Task_3
/**
 * Task_3
 * <p>
 * - Напишите обобщенный класс Pair, который представляет собой пару значений разного типа. Класс должен иметь методы
 * getFirst(), getSecond() для получения значений каждого из составляющих пары, а также переопределение метода toString(), возвращающее строковое представление пары.
 */
class Pair<T, U> {

    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
//endregion



