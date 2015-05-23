package answer;

import java.util.LinkedList;

public class SurroundedRegions {
	/**
	 * https://leetcode.com/problems/surrounded-regions/
	 */
	public void solve(char[][] board) {
        int m = board.length;
        if (m < 3) return;
        
        int n = board[0].length;
        int[][] record = new int[m][n];
        LinkedList<Integer> col = new LinkedList<Integer>();
        LinkedList<Integer> row = new LinkedList<Integer>();
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    record[i][j] = 1;
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        col.add(i);row.add(j);
                    }
                } else {
                    record[i][j] = 2;
                }
            }
        }
        
        while (!col.isEmpty()) {
            int i = col.poll();
            int j = row.poll();
            
            record[i][j] = 3;
            //left
            if (i - 1 >= 0 && record[i - 1][j] == 1) {
                record[i - 1][j] = 3;
                col.add(i - 1);row.add(j);
            }
            //right
            if (i + 1 <= m - 1 && record[i + 1][j] == 1) {
                record[i + 1][j] = 3;
                col.add(i + 1);row.add(j);
            }
            //up
            if (j - 1 >= 0 && record[i][j - 1] == 1) {
                record[i][j - 1] = 3;
                col.add(i);row.add(j - 1);
            }
            //down
            if (j + 1 <= n - 1 && record[i][j + 1] == 1) {
                record[i][j + 1] = 3;
                col.add(i);row.add(j + 1);
            }
        }
        
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (record[i][j] == 3)
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
                
    }
}
