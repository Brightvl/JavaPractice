package introduction_to_java.lesson_2.hw_2.sequence;

public class T2_SequenceCheck {
    /**
     * task_2
     *
     * @param numbers принимает массив
     * @return возвращает true если последовательность возрастающая
     */
    public static boolean AscendingSequenceCheck(int[] numbers, boolean logic) {
        boolean flag = true;
        if (logic) {
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    flag = false;
                    break;
                }
            }
        } else {
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] < numbers[i + 1]) {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }
}
