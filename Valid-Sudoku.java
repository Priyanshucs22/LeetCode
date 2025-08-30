public class Solution {
    public boolean isValidSudoku(char[][] board) {
        char num;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    num = board[i][j];
                    board[i][j] = '.';
                    if (!isValid(board, i, j, num))
                        return false;
                    board[i][j] = num;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char num) {
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num)
                return false;
        }
        int sr = row / 3 * 3;
        int sc = col / 3 * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }
}
