package JavaIntro.lesson_2.hw_2.task_4;

/* НАДО ДОДЕЛЫВАТЬ

4)() Отвалидировать доску судоку (чтобы не было пересечений)
 * /Требования
 * Объявлена доска 9 x 9 необходимо отвалидировать в соответствии с правилами
 * 1. Каждая строка должна содержать цифру 1-9 без повторения
 * 2. Каждая колонка должна содержать цифру 1-9 без повторения
 * 3. Каждый под блок из 9 элементов 3 x 3 должна содержать цифру 1-9 без повторения
 * Ограничения
 * • board.length == 9
 * • board[i].length == 9
 * • board[i][j] значение число или '.'
 * <p>
 * char[][] board = {
 * {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
 * {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
 * {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
 * {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
 * {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
 * {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
 * {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
 * {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
 * {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
 * System.out.println("Validete:" + isValidSudoku(board));
 */
public class Sudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Validate:" + isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];
            boolean[] block = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row[board[i][j] - '1']) return false;
                    row[board[i][j] - '1'] = true;
                }
                if (board[j][i] != '.') {
                    if (col[board[j][i] - '1']) return false;
                    col[board[j][i] - '1'] = true;
                }
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.') {
                    if (block[board[rowIndex + j / 3][colIndex + j % 3] - '1']) return false;
                    block[board[rowIndex + j / 3][colIndex + j % 3] - '1'] = true;
                }
            }
        }
        return true;
    }
}
