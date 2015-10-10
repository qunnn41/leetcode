package answer;

public class GameOfLife {
	/**
	 * https://leetcode.com/problems/game-of-life/
	 */
	public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int[] di = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dj = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
        
        
        /**
         * 0 : dead -> dead
         * 1 : live -> live
         * 2 : live -> dead
         * 3 : dead -> live
         */
        for (int i = 0; i < m; ++i) {
        	for (int j = 0; j < n; ++j) {
        		int live = 0;
        		for (int k = 0; k < 8; ++k) {
        			int ii = i + di[k], jj = j + dj[k];
        			if (ii < 0 || ii >= m || jj < 0 || jj >= n)
        				continue;
        			if (board[ii][jj] == 1 || board[ii][jj] == 2)
        				live ++;
        		}
        		
        		if (board[i][j] == 1 && (live < 2 || live > 3))
        			board[i][j] = 2;
        		else if (board[i][j] == 0 && live == 3)
        			board[i][j] = 3;
        	}
        }
        
        for (int i = 0; i < m; ++i) {
        	for (int j = 0; j < n; ++j) {
        		board[i][j] %= 2;
        	}
        }
        
    }
}
