package answer;

public class MinimumPathSum {
	/**
	 * https://leetcode.com/problems/minimum-path-sum/
	 */
	public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] path = new int[m][n];
        
        if (m == 1 && n == 1)
            return grid[0][0];
        
        path[m - 1][n - 1] = 0;
        for (int i = m - 2; i > -1; i --)
            path[i][n - 1] = path[i + 1][n - 1] - grid[i][n - 1];
        for (int i = n - 2; i > -1; i --)
            path[m - 1][i] = path[m - 1][i + 1] - grid[m - 1][i];
        
        for (int i = m - 2; i > -1; i --)
            for (int j = n - 2; j > -1; j --)
                path[i][j] = Math.max(path[i + 1][j], path[i][j + 1]) - grid[i][j];
        
        return grid[m - 1][n - 1] - path[0][0];
    }
}
