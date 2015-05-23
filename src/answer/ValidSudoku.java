package answer;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	/**
	 * https://leetcode.com/problems/valid-sudoku/
	 */
	public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i ++) {
            if (!isValid(board, i, 0, i, 8)) return false;
            if (!isValid(board, 0, i, 8, i)) return false;
        }
        
        for (int i = 0; i < 3; i ++)
            for (int j = 0; j < 3; j ++)
                if (!isValid(board, i * 3, j * 3, i * 3 + 2, j * 3 + 2))
                    return false;
        return true;
    }
    
    private boolean isValid(char[][] board, int x1, int y1, int x2, int y2) {
        Set<String> s = new HashSet<String>();
        for (int i = x1; i <= x2; i ++)
            for (int j = y1; j <= y2; j ++)
                if (board[i][j] != '.')
                    if (s.contains(board[i][j] + ""))
                        return false;
                    else
                        s.add(board[i][j] + "");
        return true;
    }
}
