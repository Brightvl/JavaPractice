package introductionToJava.lesson_1.hw_1;

/**
 * @Task_1
 * Учитывая входную строку s, измените порядок слов на противоположный.
 * Слово определяется как последовательность не пробельных символов.
 * Слова в s будут разделены хотя бы одним пробелом. Возвращает строку слов в обратном порядке, объединенных одним
 * пробелом. Обратите внимание, что s может содержать начальные или конечные пробелы, или несколько пробелов между
 * двумя словами. Возвращаемая строка должна содержать только один пробел, разделяющий слова. Не включайте никаких
 * дополнительных пробелов.
 *
 * @Example_1:
 * @Input: s = "the sky is blue"
 * @Output: "blue is sky the"
 *<p>
 * @Example_2:
 * @Input: s = "  hello world  "
 * @Output: "world hello"
 * @Explanation: Your reversed string should not contain leading or trailing spaces.
 *<p>
 * @Example_3:
 * @Input: s = "a good   example"
 * @Output: "example good a"
 * @Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class Task_1 {
    public static void main(String[] args) {
        System.out.println(ExpandWordOrder("the sky is blue"));

    }
    public static String ExpandWordOrder(String text){
        String[] arrayWords = text.split(" ");
        String[] reverseText = new String[arrayWords.length];
        for (int i = 0; i < arrayWords.length; i++) {
            reverseText[arrayWords.length-i-1] = arrayWords[i];
        }
        return String.join(" ", reverseText);
    }

}
