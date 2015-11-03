package answer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueensII {
	/**
	 * https://leetcode.com/problems/n-queens-ii/
	 */
	public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
		boolean[] d1 = new boolean[2 * n];
		boolean[] d2 = new boolean[2 * n];
		String[] board = new String[n];
		help(0, cols, d1, d2, board);
        return result.size();
    }
    private List<String[]> result = new LinkedList<String[]>();
	private void help(int r, boolean[] cols, boolean[]d1, boolean[]d2, String[] board) {
		if (r == board.length) {
			result.add(board.clone());
		} else {
			for (int c = 0; c < board.length; ++c) {
				int id1 = r - c + board.length;
				int id2 = 2 * board.length - r - c - 1;
				if (!cols[c] && !d1[id1] && !d2[id2]) {
					char[] row = new char[board.length];
					Arrays.fill(row, '.');
					row[c] = 'Q';
					board[r] = new String(row);
					cols[c] = true;d1[id1] = true;d2[id2] = true;
					help(r + 1, cols, d1, d2, board);
					cols[c] = false;d1[id1] = false;d2[id2] = false;
				}
			}
		}
	}
}
