package answer;

public class SodukuSolver {
	/**
	 * https://leetcode.com/problems/sudoku-solver/
	 */
	public void solveSudoku(char[][] board) {
		helper(board);
	}
	
	private boolean helper(char[][] board) {
		for (int x = 0; x < 9; ++x) {
			for (int y = 0; y < 9; ++y) {
				if (board[x][y] == '.') {
					for (char ch = '1'; ch <= '9'; ++ch) {
						if (isValid(board, x, y, ch)) {
							board[x][y] = ch;
							if (helper(board)) {
								return true;
							} else {
								board[x][y] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean isValid(char[][]board, int x, int y, char ch) {
		for (int i = 0; i < 9; ++i)
			if (board[x][i] == ch)
				return false;
		for (int i = 0; i < 9; ++i)
			if (board[i][y] == ch)
				return false;
		for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; ++i)
			for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; ++j)
				if (board[i][j] == ch)
					return false;
		return true;
	}
}
